package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.convert.AuthPermissionBOConvert;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Override
    public Boolean addPermission(AuthPermissionBo authPermissionBo) {
        AuthPermission authPermission = AuthPermissionBOConvert.INSTANCE.convertPermissionBoToEntity(authPermissionBo);
        authPermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        Integer count = authPermissionService.insert(authPermission);
        return count > 0;
    }

    @Override
    public Boolean updatePermission(AuthPermissionBo authPermissionBo) {
        AuthPermission authPermission = AuthPermissionBOConvert.INSTANCE.convertPermissionBoToEntity(authPermissionBo);
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }

    @Override
    public Boolean deletePermission(AuthPermissionBo authPermissionBo) {
        AuthPermission authPermission = AuthPermissionBOConvert.INSTANCE.convertPermissionBoToEntity(authPermissionBo);
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }
}
