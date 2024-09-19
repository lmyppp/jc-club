package com.jingdianjichi.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2023-11-08 20:16:41
 */
@Data
public class AuthRolePermission implements Serializable {
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
    
    private String createdBy;
    
    private Date createdTime;
    
    private String updateBy;
    
    private Date updateTime;
    
    private Integer isDeleted;



}