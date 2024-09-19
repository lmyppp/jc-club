package com.jingdianjichi.subject.domain.entity;

import com.jingdianjichi.subject.common.pageentity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 存放题目答案或者题目选项的实体
 * 简答题：存放subjectAnswer，optionList为空
 * 其他：存放optionList，存放subjectAnswer为空
 *
 * @author makejava
 * @since 2023-10-07 09:20:55
 */
@Data
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = 245090673344027223L;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;

}