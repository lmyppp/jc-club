package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthRolePermissionDTOConverterImpl implements AuthRolePermissionDTOConverter {

    @Override
    public AuthRolePermissionBo convertRolePermissionDTOToBo(AuthRolePermissionDTO authRolePermissionDTO) {
        if ( authRolePermissionDTO == null ) {
            return null;
        }

        AuthRolePermissionBo authRolePermissionBo = new AuthRolePermissionBo();

        authRolePermissionBo.setId( authRolePermissionDTO.getId() );
        authRolePermissionBo.setRoleId( authRolePermissionDTO.getRoleId() );
        authRolePermissionBo.setPermissionId( authRolePermissionDTO.getPermissionId() );
        List<Integer> list = authRolePermissionDTO.getPermissionIdList();
        if ( list != null ) {
            authRolePermissionBo.setPermissionIdList( new ArrayList<Integer>( list ) );
        }
        authRolePermissionBo.setIsDeleted( authRolePermissionDTO.getIsDeleted() );

        return authRolePermissionBo;
    }
}
