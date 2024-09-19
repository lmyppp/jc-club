package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;

import java.util.List;

/**
 * (AuthPermission)表服务接口
 *
 */
public interface AuthPermissionDomainService {


    Boolean addPermission(AuthPermissionBo authPermissionBo);

    Boolean updatePermission(AuthPermissionBo authPermissionBo);

    Boolean deletePermission(AuthPermissionBo authPermissionBo);
}