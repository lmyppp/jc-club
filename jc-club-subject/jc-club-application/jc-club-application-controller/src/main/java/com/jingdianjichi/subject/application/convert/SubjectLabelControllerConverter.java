package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.entity.SubjectLabelDTO;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelControllerConverter {

    SubjectLabelControllerConverter INSTANCE = Mappers.getMapper(SubjectLabelControllerConverter.class);
    SubjectLabelBO convertDtoToBo(SubjectLabelDTO subjectLabelDTO);
    List<SubjectLabelDTO> convertBoToDtoList(List<SubjectLabelBO> subjectLabelBOList);
    SubjectLabelDTO convertBoToDto(SubjectLabelBO subjectLabelBO);

}
