package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.entity.SubjectInfoDTO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoControllerConverter {

    SubjectInfoControllerConverter INSTANCE = Mappers.getMapper(SubjectInfoControllerConverter.class);
    SubjectInfoBO convertDtoToBo(SubjectInfoDTO subjectInfoDTO);
    List<SubjectInfoDTO> convertBoToDtoList(List<SubjectInfoBO> subjectInfoBOList);
    SubjectInfoDTO convertBoToDto(SubjectInfoBO subjectInfoBO);

}
