package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限Bo转换器
 */
@Mapper
public interface AuthPermissionBOConvert {

    AuthPermissionBOConvert INSTANCE = Mappers.getMapper(AuthPermissionBOConvert.class);

    AuthPermission convertPermissionBoToEntity(AuthPermissionBo authPermissionBo);


}
