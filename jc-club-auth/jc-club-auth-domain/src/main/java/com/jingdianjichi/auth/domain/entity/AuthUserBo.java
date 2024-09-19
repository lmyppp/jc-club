package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthUser)BO
 *
 */
@Data
public class AuthUserBo implements Serializable {
    private static final long serialVersionUID = 245491772396169522L;

    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 昵称
    */
    private String nickName;
    /**
    * 邮件
    */
    private String email;
    /**
    * 电话
    */
    private String phone;
    /**
    * 密码
    */
    private String password;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 用户状态
    */
    private Integer status;
    /**
    * 个人介绍
    */
    private String introduce;
    /**
    * 特殊字段
    */
    private String extJson;

    private Integer isDeleted;




}