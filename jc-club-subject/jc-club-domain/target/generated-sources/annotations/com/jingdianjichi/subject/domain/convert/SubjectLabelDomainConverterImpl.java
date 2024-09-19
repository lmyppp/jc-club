package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-02T21:09:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class SubjectLabelDomainConverterImpl implements SubjectLabelDomainConverter {

    @Override
    public SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( subjectLabelBO.getId() );
        subjectLabel.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabel.setCategoryId( subjectLabelBO.getCategoryId() );
        subjectLabel.setSortNum( subjectLabelBO.getSortNum() );
        subjectLabel.setCreatedBy( subjectLabelBO.getCreatedBy() );
        subjectLabel.setCreatedTime( subjectLabelBO.getCreatedTime() );
        subjectLabel.setUpdateBy( subjectLabelBO.getUpdateBy() );
        subjectLabel.setUpdateTime( subjectLabelBO.getUpdateTime() );
        subjectLabel.setIsDeleted( subjectLabelBO.getIsDeleted() );

        return subjectLabel;
    }

    @Override
    public List<SubjectLabelBO> convertLabelToBoList(List<SubjectLabel> subjectLabelList) {
        if ( subjectLabelList == null ) {
            return null;
        }

        List<SubjectLabelBO> list = new ArrayList<SubjectLabelBO>( subjectLabelList.size() );
        for ( SubjectLabel subjectLabel : subjectLabelList ) {
            list.add( convertLabelToBo( subjectLabel ) );
        }

        return list;
    }

    @Override
    public SubjectLabelBO convertLabelToBo(SubjectLabel subjectLabel) {
        if ( subjectLabel == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( subjectLabel.getId() );
        subjectLabelBO.setLabelName( subjectLabel.getLabelName() );
        subjectLabelBO.setSortNum( subjectLabel.getSortNum() );
        subjectLabelBO.setCreatedBy( subjectLabel.getCreatedBy() );
        subjectLabelBO.setCreatedTime( subjectLabel.getCreatedTime() );
        subjectLabelBO.setUpdateBy( subjectLabel.getUpdateBy() );
        subjectLabelBO.setUpdateTime( subjectLabel.getUpdateTime() );
        subjectLabelBO.setIsDeleted( subjectLabel.getIsDeleted() );
        subjectLabelBO.setCategoryId( subjectLabel.getCategoryId() );

        return subjectLabelBO;
    }
}
