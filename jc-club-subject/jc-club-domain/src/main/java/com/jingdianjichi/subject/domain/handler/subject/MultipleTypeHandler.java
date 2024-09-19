package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.MultipleSubjectDomainConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import com.jingdianjichi.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //多选题目插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
        for (SubjectAnswerBO subjectAnswerBO : optionList) {
            SubjectMultiple subjectMultiple = MultipleSubjectDomainConverter.INSTANCE.convertBoToEntity(subjectAnswerBO);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            subjectMultipleList.add(subjectMultiple);
        }
        subjectMultipleService.batchInsert(subjectMultipleList);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId);
        List<SubjectMultiple> subjectMultipleList = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOS = MultipleSubjectDomainConverter.INSTANCE.convertEntityToBoList(subjectMultipleList);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOS);
        return subjectOptionBO;
    }
}
