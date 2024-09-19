package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthRoleDTOConverterImpl implements AuthRoleDTOConverter {

    @Override
    public AuthRoleBo convertRoleDTOToBo(AuthRoleDTO authRoleDTO) {
        if ( authRoleDTO == null ) {
            return null;
        }

        AuthRoleBo authRoleBo = new AuthRoleBo();

        authRoleBo.setId( authRoleDTO.getId() );
        authRoleBo.setRoleName( authRoleDTO.getRoleName() );
        authRoleBo.setRoleKey( authRoleDTO.getRoleKey() );
        authRoleBo.setIsDeleted( authRoleDTO.getIsDeleted() );

        return authRoleBo;
    }
}
