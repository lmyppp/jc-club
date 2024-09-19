package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (AuthPermission)实体类
 */
@Data
public class AuthPermissionBo implements Serializable {
    private static final long serialVersionUID = 884437324304658689L;
    
    private Integer id;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 父id
    */
    private Integer parentId;
    /**
    * 权限类型 0菜单 1操作
    */
    private Integer type;
    /**
    * 菜单路由
    */
    private String menuUrl;
    /**
    * 状态 0启用 1禁用
    */
    private Integer status;
    /**
    * 展示状态 0展示 1隐藏
    */
    private Integer show;
    
    private String icon;
    
    private String permissionKey;
    
    private Integer isDeleted;

}