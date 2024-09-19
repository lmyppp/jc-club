package com.jingdianjichi.subject.infra.basic.mapper;

import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 简答题(SubjectBrief)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-07 09:26:32
 */
@Mapper
public interface SubjectBriefDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectBrief queryById(Integer id);

    /**
     * 根据实体查询指定行数据
     */
    SubjectBrief queryAllByBrief(SubjectBrief subjectBrief);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectBrief 实例对象
     * @return 对象列表
     */
    List<SubjectBrief> queryAll(SubjectBrief subjectBrief);

    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 影响行数
     */
    int insert(SubjectBrief subjectBrief);

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 影响行数
     */
    int update(SubjectBrief subjectBrief);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}