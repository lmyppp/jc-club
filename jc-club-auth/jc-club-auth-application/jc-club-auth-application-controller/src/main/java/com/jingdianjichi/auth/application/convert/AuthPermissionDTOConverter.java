package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限DTO转换器
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBo convertPermissionDTOToBo(AuthPermissionDTO authPermissionDTO);


}
