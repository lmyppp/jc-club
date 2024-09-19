package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * (AuthRole)服务层接口
 */
public interface AuthRoleDomainService {


    Boolean addRole(AuthRoleBo authRoleBo);

    Boolean updateRole(AuthRoleBo authRoleBo);

    Boolean deleteRole(AuthRoleBo authRoleBo);
}