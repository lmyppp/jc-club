package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthRoleBOConvertImpl implements AuthRoleBOConvert {

    @Override
    public AuthRole convertRoleBoToEntity(AuthRoleBo authRoleBo) {
        if ( authRoleBo == null ) {
            return null;
        }

        AuthRole authRole = new AuthRole();

        authRole.setId( authRoleBo.getId() );
        authRole.setRoleName( authRoleBo.getRoleName() );
        authRole.setRoleKey( authRoleBo.getRoleKey() );
        authRole.setIsDeleted( authRoleBo.getIsDeleted() );

        return authRole;
    }
}
