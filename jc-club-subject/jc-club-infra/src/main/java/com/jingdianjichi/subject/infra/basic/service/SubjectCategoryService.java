package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2023-10-03 01:15:51
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除分类
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询大类分类
     *
     * @return
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);
}