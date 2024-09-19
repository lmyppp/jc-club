package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;

import java.util.List;

public interface AuthUserDomainService {

    /**
     * 用户注册
     */
    Boolean register(AuthUserBo authUserBo);

    /**
     * 修改用户信息
     */
    Boolean update(AuthUserBo authUserBo);

    void delete(AuthUserBo authUserBo);

    Boolean changeStatus(AuthUserBo authUserBo);
}
