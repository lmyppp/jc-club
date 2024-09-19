package com.jingdianjichi.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 */
@Data
public class AuthRole implements Serializable {
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
    
    private String createdBy;
    
    private Date createdTime;
    
    private String updateBy;
    
    private Date updateTime;
    
    private Integer isDeleted;




}