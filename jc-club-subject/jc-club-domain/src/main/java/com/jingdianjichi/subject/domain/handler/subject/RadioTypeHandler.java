package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.RadioSubjectDomainConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
        for (SubjectAnswerBO subjectAnswerBO : optionList) {
            SubjectRadio subjectRadio = RadioSubjectDomainConverter.INSTANCE.convertBoToEntity(subjectAnswerBO);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            subjectRadioList.add(subjectRadio);
        }
        subjectRadioService.batchInsert(subjectRadioList);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(subjectId);
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);//根据subjectId查询答案，一对多。一个题4个答案
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectDomainConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
