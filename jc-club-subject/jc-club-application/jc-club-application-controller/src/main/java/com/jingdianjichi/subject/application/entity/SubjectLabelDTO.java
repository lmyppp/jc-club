package com.jingdianjichi.subject.application.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2023-10-05 21:06:16
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = -87449607865630084L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 标签分类
    */
    private String labelName;
    /**
    * 排序
    */
    private Integer sortNum;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除
    */
    private Integer isDeleted;

    /**
     * 分类id
     */
    private Integer categoryId;



}