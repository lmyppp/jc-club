package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色权限关联表Bo转换器
 */
@Mapper
public interface AuthRolePermissionBoConverter {

    AuthRolePermissionBoConverter INSTANCE = Mappers.getMapper(AuthRolePermissionBoConverter.class);

    AuthRolePermission convertRolePermissionBoToEntity(AuthRolePermissionBo authRolePermissionBo);


}
