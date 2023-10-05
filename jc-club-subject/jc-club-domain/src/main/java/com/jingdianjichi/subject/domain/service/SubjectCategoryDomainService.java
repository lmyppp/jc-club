package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectCategoryDomainService {
    /**
     * 新增数据
     *
     * @param subjectCategoryBO 实例对象
     * @return 实例对象
     */
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询大类分类
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     */
    boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 根据id删除分类
     */
    boolean delete(SubjectCategoryBO subjectCategoryBO);
}
