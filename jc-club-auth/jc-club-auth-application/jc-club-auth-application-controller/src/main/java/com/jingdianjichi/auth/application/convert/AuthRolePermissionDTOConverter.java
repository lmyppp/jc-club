package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色权限关联表DTO转换器
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBo convertRolePermissionDTOToBo(AuthRolePermissionDTO authRolePermissionDTO);


}
