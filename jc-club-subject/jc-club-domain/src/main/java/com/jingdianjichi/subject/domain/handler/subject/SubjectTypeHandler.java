package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import org.springframework.stereotype.Component;

@Component
public interface SubjectTypeHandler {
    /**
     * 枚举身份的识别
     *
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     *
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     *
     * @param subjectId
     */
    SubjectOptionBO query(int subjectId);
}
