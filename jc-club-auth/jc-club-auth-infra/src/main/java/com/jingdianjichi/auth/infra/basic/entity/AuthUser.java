package com.jingdianjichi.auth.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthUser)实体类
 *
 * @author makejava
 * @since 2023-11-06 19:45:34
 */
public class AuthUser implements Serializable {
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
    
    private String createdBy;
    
    private Date createdTime;
    
    private String updateBy;
    
    private Double updateTime;
    
    private Integer isDeleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Double getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Double updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}