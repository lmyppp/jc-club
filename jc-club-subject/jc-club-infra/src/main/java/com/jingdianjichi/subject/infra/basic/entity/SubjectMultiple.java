package com.jingdianjichi.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 多选题信息表(SubjectMultiple)实体类
 *
 * @author makejava
 * @since 2023-10-07 09:28:13
 */
@Data
public class SubjectMultiple implements Serializable {
    private static final long serialVersionUID = 187789870935215769L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 题目id
    */
    private Integer subjectId;
    /**
    * 选项类型
    */
    private Integer optionType;
    /**
    * 选项内容
    */
    private String optionContent;
    /**
    * 是否正确
    */
    private Integer isCorrect;
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



}