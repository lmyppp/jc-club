package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色Bo转换器
 */
@Mapper
public interface AuthRoleBOConvert {

    AuthRoleBOConvert INSTANCE = Mappers.getMapper(AuthRoleBOConvert.class);

    AuthRole convertRoleBoToEntity(AuthRoleBo authRoleBo);


}
