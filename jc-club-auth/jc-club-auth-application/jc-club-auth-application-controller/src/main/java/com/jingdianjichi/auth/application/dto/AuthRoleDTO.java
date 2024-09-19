package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRole)实体类
 *
 */
@Data
public class AuthRoleDTO implements Serializable {
    private static final long serialVersionUID = 661230678221294931L;
    
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色唯一标识
    */
    private String roleKey;

    private Integer isDeleted;




}