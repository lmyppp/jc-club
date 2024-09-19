package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthPermissionDTOConverterImpl implements AuthPermissionDTOConverter {

    @Override
    public AuthPermissionBo convertPermissionDTOToBo(AuthPermissionDTO authPermissionDTO) {
        if ( authPermissionDTO == null ) {
            return null;
        }

        AuthPermissionBo authPermissionBo = new AuthPermissionBo();

        authPermissionBo.setId( authPermissionDTO.getId() );
        authPermissionBo.setName( authPermissionDTO.getName() );
        authPermissionBo.setParentId( authPermissionDTO.getParentId() );
        authPermissionBo.setType( authPermissionDTO.getType() );
        authPermissionBo.setMenuUrl( authPermissionDTO.getMenuUrl() );
        authPermissionBo.setStatus( authPermissionDTO.getStatus() );
        authPermissionBo.setShow( authPermissionDTO.getShow() );
        authPermissionBo.setIcon( authPermissionDTO.getIcon() );
        authPermissionBo.setPermissionKey( authPermissionDTO.getPermissionKey() );
        authPermissionBo.setIsDeleted( authPermissionDTO.getIsDeleted() );

        return authPermissionBo;
    }
}
