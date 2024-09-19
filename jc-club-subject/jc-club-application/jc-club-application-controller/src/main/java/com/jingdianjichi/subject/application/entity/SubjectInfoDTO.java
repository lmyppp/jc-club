package com.jingdianjichi.subject.application.entity;

import com.jingdianjichi.subject.common.pageentity.PageInfo;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)实体类
 *
 * @author makejava
 * @since 2023-10-07 09:20:55
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
    private static final long serialVersionUID = 245090673344027223L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 分类id
     */
    private List<Integer> categoryIds;
    /**
     * 标签id
     */
    private List<Integer> labelIds;
    /**
     * 标签名称
     */
    private List<String> labelName;
    /**
     * 答案选项
     */
    private List<SubjectAnswerDTO> optionList;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 标签id
     */
    private Integer labelId;


}