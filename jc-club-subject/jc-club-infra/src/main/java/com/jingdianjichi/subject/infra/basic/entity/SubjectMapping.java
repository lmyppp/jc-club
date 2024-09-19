package com.jingdianjichi.subject.infra.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类关系表(SubjectMapping)实体类
 *
 * @author makejava
 * @since 2023-10-06 00:18:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = -51337858064141843L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 题目id
    */
    private Integer subjectId;
    /**
    * 分类id
    */
    private Integer categoryId;
    /**
    * 标签id
    */
    private Integer labelId;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 修改人
    */
    private String updateBy;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 是否删除
    */
    private Integer isDeleted;


}