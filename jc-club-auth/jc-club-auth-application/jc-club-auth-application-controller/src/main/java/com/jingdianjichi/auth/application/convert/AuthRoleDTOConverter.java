package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户DTO转换器
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBo convertRoleDTOToBo(AuthRoleDTO authRoleDTO);


}
