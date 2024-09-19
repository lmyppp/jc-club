package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthUserDTOConverterImpl implements AuthUserDTOConverter {

    @Override
    public AuthUserBo convertDTOToBo(AuthUserDTO authUserDTO) {
        if ( authUserDTO == null ) {
            return null;
        }

        AuthUserBo authUserBo = new AuthUserBo();

        authUserBo.setId( authUserDTO.getId() );
        authUserBo.setUserName( authUserDTO.getUserName() );
        authUserBo.setNickName( authUserDTO.getNickName() );
        authUserBo.setEmail( authUserDTO.getEmail() );
        authUserBo.setPhone( authUserDTO.getPhone() );
        authUserBo.setPassword( authUserDTO.getPassword() );
        authUserBo.setSex( authUserDTO.getSex() );
        authUserBo.setAvatar( authUserDTO.getAvatar() );
        authUserBo.setStatus( authUserDTO.getStatus() );
        authUserBo.setIntroduce( authUserDTO.getIntroduce() );
        authUserBo.setExtJson( authUserDTO.getExtJson() );
        authUserBo.setIsDeleted( authUserDTO.getIsDeleted() );

        return authUserBo;
    }
}
