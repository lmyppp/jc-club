package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (AuthRolePermission)实体类

 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    private static final long serialVersionUID = -79942790676919729L;
    
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 权限id
    */
    private Integer permissionId;
    /**
     * 权限id集合
     */
    private List<Integer> permissionIdList;
    
    private Integer isDeleted;



}