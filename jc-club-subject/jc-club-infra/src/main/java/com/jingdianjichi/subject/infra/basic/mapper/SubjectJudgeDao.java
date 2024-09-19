package com.jingdianjichi.subject.infra.basic.mapper;

import com.jingdianjichi.subject.infra.basic.entity.SubjectJudge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 判断题(SubjectJudge)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-07 09:27:22
 */
@Mapper
public interface SubjectJudgeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectJudge queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectJudge> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectJudge 实例对象
     * @return 对象列表
     */
    List<SubjectJudge> queryAll(SubjectJudge subjectJudge);

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 影响行数
     */
    int insert(SubjectJudge subjectJudge);

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 影响行数
     */
    int update(SubjectJudge subjectJudge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<SubjectJudge> queryByJudge(SubjectJudge subjectJudge);
}