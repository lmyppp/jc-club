package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthRolePermissionBoConverterImpl implements AuthRolePermissionBoConverter {

    @Override
    public AuthRolePermission convertRolePermissionBoToEntity(AuthRolePermissionBo authRolePermissionBo) {
        if ( authRolePermissionBo == null ) {
            return null;
        }

        AuthRolePermission authRolePermission = new AuthRolePermission();

        authRolePermission.setId( authRolePermissionBo.getId() );
        authRolePermission.setRoleId( authRolePermissionBo.getRoleId() );
        authRolePermission.setPermissionId( authRolePermissionBo.getPermissionId() );
        authRolePermission.setIsDeleted( authRolePermissionBo.getIsDeleted() );

        return authRolePermission;
    }
}
