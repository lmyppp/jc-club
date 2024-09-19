package com.jingdianjichi.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2023-10-07 09:27:22
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = -19826798028526653L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 题目id
    */
    private Integer subjectId;
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