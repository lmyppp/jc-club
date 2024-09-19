package com.jingdianjichi.subject.infra.basic.mapper;

import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 多选题信息表(SubjectMultiple)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-07 09:28:13
 */
@Mapper
public interface SubjectMultipleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectMultiple> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectMultiple 实例对象
     * @return 对象列表
     */
    List<SubjectMultiple> queryAll(SubjectMultiple subjectMultiple);

    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 影响行数
     */
    int insert(SubjectMultiple subjectMultiple);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 影响行数
     */
    int update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 批量添加多选题
     * @param subjectMultipleList
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);

    /**
     * 根据实体查询实体内容集合
     * @param subjectMultiple
     * @return
     */
    List<SubjectMultiple> queryAllByMultiple(SubjectMultiple subjectMultiple);
}