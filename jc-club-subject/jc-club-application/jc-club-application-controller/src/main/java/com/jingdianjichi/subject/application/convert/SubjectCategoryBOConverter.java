package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.entity.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryBOConverter {

    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);
    SubjectCategoryBO convertDtoToBo(SubjectCategoryDTO subjectCategoryDTO);
    List<SubjectCategoryDTO> convertBoToDto(List<SubjectCategoryBO> subjectCategoryBOList);

}
