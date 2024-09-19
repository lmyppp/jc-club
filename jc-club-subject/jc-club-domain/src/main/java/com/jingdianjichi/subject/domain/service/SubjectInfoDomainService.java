package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.common.pageentity.PageResult;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import org.springframework.stereotype.Service;

@Service
public interface SubjectInfoDomainService {
    /**
     * 新增题目
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
