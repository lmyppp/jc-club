package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthPermissionBOConvertImpl implements AuthPermissionBOConvert {

    @Override
    public AuthPermission convertPermissionBoToEntity(AuthPermissionBo authPermissionBo) {
        if ( authPermissionBo == null ) {
            return null;
        }

        AuthPermission authPermission = new AuthPermission();

        authPermission.setId( authPermissionBo.getId() );
        authPermission.setName( authPermissionBo.getName() );
        authPermission.setParentId( authPermissionBo.getParentId() );
        authPermission.setType( authPermissionBo.getType() );
        authPermission.setMenuUrl( authPermissionBo.getMenuUrl() );
        authPermission.setStatus( authPermissionBo.getStatus() );
        authPermission.setShow( authPermissionBo.getShow() );
        authPermission.setIcon( authPermissionBo.getIcon() );
        authPermission.setPermissionKey( authPermissionBo.getPermissionKey() );
        authPermission.setIsDeleted( authPermissionBo.getIsDeleted() );

        return authPermission;
    }
}
