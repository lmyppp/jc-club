package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户DTO转换器
 */
@Mapper
public interface AuthUserDTOConverter {

    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBo convertDTOToBo(AuthUserDTO authUserDTO);


}
