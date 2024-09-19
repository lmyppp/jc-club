package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;

/**
 * (AuthRolePermission)表服务接口
 *
 */
public interface AuthRolePermissionDomainService {

    Boolean addRolePermission(AuthRolePermissionBo authRolePermissionBo);
}