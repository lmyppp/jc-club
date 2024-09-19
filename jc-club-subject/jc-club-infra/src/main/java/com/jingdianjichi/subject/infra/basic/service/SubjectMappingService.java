package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2023-10-06 00:18:39
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param  subjectMapping
     * @return 实例对象
     */
    SubjectMapping queryById(SubjectMapping subjectMapping);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectMapping> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping insert(SubjectMapping subjectMapping);

    /**
     * 批量新增数据
     *
     * @param subjectMappingList 实例对象
     * @return 实例对象
     */
    void batchInsert(List<SubjectMapping> subjectMappingList);
    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping update(SubjectMapping subjectMapping);

    /**
     * 查询标签id
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);


}