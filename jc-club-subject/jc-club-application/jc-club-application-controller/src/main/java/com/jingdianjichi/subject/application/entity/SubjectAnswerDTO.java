package com.jingdianjichi.subject.application.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目答案DTO
 * @author makejava
 * @since 2023-10-07 09:20:55
 */
@Data
public class SubjectAnswerDTO implements Serializable {
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