package com.jingdianjichi.subject.infra.basic.mapper;

import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 单选题信息表(SubjectRadio)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-07 09:28:35
 */
@Mapper
public interface SubjectRadioDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectRadio> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectRadio 实例对象
     * @return 对象列表
     */
    List<SubjectRadio> queryAll(SubjectRadio subjectRadio);

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 影响行数
     */
    int insert(@Param("subjectRadio") SubjectRadio subjectRadio);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 影响行数
     */
    int update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 批量新增数据
     * @param subjectRadioList
     */
    void batchInsert(List<SubjectRadio> subjectRadioList);

    /**
     * 根据单选实体（内置projectId）查询对应的数据
     * @param subjectRadio
     * @return
     */
    List<SubjectRadio> queryAllByRadio(SubjectRadio subjectRadio);
}