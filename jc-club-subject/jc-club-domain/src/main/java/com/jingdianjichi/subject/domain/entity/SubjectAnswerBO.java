package com.jingdianjichi.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案BO,用来存放单选，多选，判断的选项
 * @author makejava
 * @since 2023-10-07 09:20:55
 */
@Data
public class SubjectAnswerBO implements Serializable {
    private static final long serialVersionUID = 245090673344027223L;
    /**
    * 类型
    */
    private Integer optionType;
    /**
    * 答案内容
    */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;




}