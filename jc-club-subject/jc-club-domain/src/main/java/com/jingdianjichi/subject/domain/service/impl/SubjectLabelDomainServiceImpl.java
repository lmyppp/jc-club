package com.jingdianjichi.subject.domain.service.impl;


import com.jingdianjichi.subject.common.enums.CategoryTypeEnum;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.convert.SubjectLabelDomainConverter;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2023-10-05 21:06:17
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectCategoryService subjectCategoryService;

    /**
     * 新增数据
     *
     * @param subjectLabelBO 实例对象
     * @return 实例对象
     */
    @Override
    public void add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        this.subjectLabelService.insert(subjectLabel);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByPrimaryId(SubjectLabelBO subjectLabelBO) {
        //如果当前分类是1级分类，则查询所有标签
        SubjectCategory subjectCategory = subjectCategoryService.queryById(subjectLabelBO.getCategoryId());
        if (CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()) {
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBO.getCategoryId());
            List<SubjectLabel> labelList = subjectLabelService.queryByCondition(subjectLabel);
            List<SubjectLabelBO> subjectLabelBOList = SubjectLabelDomainConverter.INSTANCE.convertLabelToBoList(labelList);
            return subjectLabelBOList;
        }


        Integer categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Integer> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> labelBoList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            labelBoList.add(bo);
        });
        return labelBoList;
    }

    @Override
    public boolean update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelDomainConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }


}