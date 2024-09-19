package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.BriefSubjectDomainConverter;
import com.jingdianjichi.subject.domain.convert.RadioSubjectDomainConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 简答题目的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //简答题目插入
        SubjectBrief subjectBrief = BriefSubjectDomainConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        subjectBriefService.insert(subjectBrief);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();//创建简答题对象
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);//根据简答题对象（subjectId）查询简答题具体信息
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();//创建OptionBO对象，用来存放题目具体信息.一个题，一个答案，一对一
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
