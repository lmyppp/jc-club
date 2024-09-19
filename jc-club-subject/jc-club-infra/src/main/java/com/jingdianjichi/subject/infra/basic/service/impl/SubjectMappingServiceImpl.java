package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectMappingDao;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务实现类
 *
 * @author makejava
 * @since 2023-10-06 00:18:39
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl implements SubjectMappingService  {
    @Resource
    private SubjectMappingDao subjectMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  subjectMapping
     * @return 实例对象
     */
    @Override
    public SubjectMapping queryById(SubjectMapping subjectMapping) {
        return this.subjectMappingDao.queryById(subjectMapping);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SubjectMapping> queryAllByLimit(int offset, int limit) {
        return this.subjectMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping insert(SubjectMapping subjectMapping) {
        this.subjectMappingDao.insert(subjectMapping);
        return subjectMapping;
    }

    /**
     * 批量新增
     * @param subjectMappingList 实例对象
     */
    @Override
    public void batchInsert(List<SubjectMapping> subjectMappingList) {
        this.subjectMappingDao.batchInsert(subjectMappingList);
    }

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping update(SubjectMapping subjectMapping) {
        this.subjectMappingDao.update(subjectMapping);
        return this.queryById(subjectMapping);
    }

    /**
     * 查询标签id
     */
    @Override
    public List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping) {
        List<SubjectMapping> subjectMappingList = subjectMappingDao.queryDistinceLabelId(subjectMapping);
        return subjectMappingList;
    }


}