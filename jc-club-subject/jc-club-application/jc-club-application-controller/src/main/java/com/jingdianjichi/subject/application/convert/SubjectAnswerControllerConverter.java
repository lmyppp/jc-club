package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.entity.SubjectAnswerDTO;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerControllerConverter {

    SubjectAnswerControllerConverter INSTANCE = Mappers.getMapper(SubjectAnswerControllerConverter.class);

    SubjectAnswerBO convertDtoToBo(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertDtoToBoList(List<SubjectAnswerDTO> subjectAnswerDTOList);


}
