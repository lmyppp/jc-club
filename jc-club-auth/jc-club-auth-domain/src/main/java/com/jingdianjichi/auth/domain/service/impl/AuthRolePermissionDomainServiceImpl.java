package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.convert.AuthRolePermissionBoConverter;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean addRolePermission(AuthRolePermissionBo authRolePermissionBo) {
        /*//第一种方式：需要与数据库多次交互，影响性能
        List<Integer> permissionIdList = authRolePermissionBo.getPermissionIdList();
        permissionIdList.forEach(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(authRolePermissionBo.getRoleId());
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            authRolePermissionService.insert(authRolePermission);
        });
        return true;*/

        //第二种方式：把需要插入数据库的数据放到list中，sql遍历插入，只需要和数据库交互一次
        List<AuthRolePermission> authRolePermissionList = new LinkedList<>();
        List<Integer> permissionIdList = authRolePermissionBo.getPermissionIdList();
        permissionIdList.forEach(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(authRolePermissionBo.getRoleId());
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            authRolePermissionList.add(authRolePermission);
        });
        Integer count = authRolePermissionService.batchInsert(authRolePermissionList);

        return count > 0;
    }
}
