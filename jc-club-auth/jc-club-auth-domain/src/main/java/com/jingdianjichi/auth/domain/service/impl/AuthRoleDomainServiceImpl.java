package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.constants.PermissionConstant;
import com.jingdianjichi.auth.domain.convert.AuthRoleBOConvert;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.domain.service.AuthRoleDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.service.AuthPermissionService;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import com.jingdianjichi.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Resource
    private AuthPermissionService authPermissionService;

    @Override
    public Boolean addRole(AuthRoleBo authRoleBo) {
        AuthRole authRole = AuthRoleBOConvert.INSTANCE.convertRoleBoToEntity(authRoleBo);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        Integer count = this.authRoleService.insert(authRole);
        return  count> 0;
    }

    @Override
    public Boolean updateRole(AuthRoleBo authRoleBo) {
        AuthRole authRole = AuthRoleBOConvert.INSTANCE.convertRoleBoToEntity(authRoleBo);
        return this.authRoleService.update(authRole) > 0;
    }

    @Override
    public Boolean deleteRole(AuthRoleBo authRoleBo) {
        AuthRole authRole = AuthRoleBOConvert.INSTANCE.convertRoleBoToEntity(authRoleBo);
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return this.authRoleService.update(authRole) > 0;
    }
}
