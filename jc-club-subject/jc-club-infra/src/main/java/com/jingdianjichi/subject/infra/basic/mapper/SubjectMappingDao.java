package com.jingdianjichi.subject.infra.basic.mapper;

import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-06 00:18:38
 */
@Mapper
public interface SubjectMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  subjectMapping
     * @return 实例对象
     */
    SubjectMapping queryById(SubjectMapping subjectMapping);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectMapping> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectMapping 实例对象
     * @return 对象列表
     */
    List<SubjectMapping> queryAll(SubjectMapping subjectMapping);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 影响行数
     */
    int insert(@Param("subjectMapping") SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 影响行数
     */
    int update(SubjectMapping subjectMapping);

    /**
     * 根据分类id查询所有的映射数据
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryDistinceLabelId(SubjectMapping subjectMapping);

    /**
     * 批量新增
     * @param subjectMappingList
     */
    int batchInsert(@Param("subjectMappingList") List<SubjectMapping> subjectMappingList);
}