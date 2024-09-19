package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 * InitializingBean:作用：当此类加载完后，afterPropertiesSet方法代码已经跑完。
 * 此处的主要目的就是把subjectTypeHandlerList放到map中。
 * 也可以把遍历插入的代码直接在代码中写就行。
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    public List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }



}
