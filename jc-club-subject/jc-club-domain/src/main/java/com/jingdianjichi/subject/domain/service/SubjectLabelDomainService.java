package com.jingdianjichi.subject.domain.service;


import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2023-10-05 21:06:17
 */
@Service
public interface SubjectLabelDomainService {

    /**
     * 新增数据
     *
     * @param subjectLabelBO 实例对象
     * @return 实例对象
     */
    void add(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类Id查询分类下标签
     */
    List<SubjectLabelBO> queryLabelByPrimaryId(SubjectLabelBO subjectLabelBO);


    /**
     * 更新标签
     * @param subjectLabelBO
     */
    boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO
     * @return
     */
    boolean delete(SubjectLabelBO subjectLabelBO);
}