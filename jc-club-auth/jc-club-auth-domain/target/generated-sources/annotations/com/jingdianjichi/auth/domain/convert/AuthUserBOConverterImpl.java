package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T20:36:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthUserBOConverterImpl implements AuthUserBOConverter {

    @Override
    public AuthUser convertBoToEntity(AuthUserBo authUserBo) {
        if ( authUserBo == null ) {
            return null;
        }

        AuthUser authUser = new AuthUser();

        authUser.setId( authUserBo.getId() );
        authUser.setUserName( authUserBo.getUserName() );
        authUser.setNickName( authUserBo.getNickName() );
        authUser.setEmail( authUserBo.getEmail() );
        authUser.setPhone( authUserBo.getPhone() );
        authUser.setPassword( authUserBo.getPassword() );
        authUser.setSex( authUserBo.getSex() );
        authUser.setAvatar( authUserBo.getAvatar() );
        authUser.setStatus( authUserBo.getStatus() );
        authUser.setIntroduce( authUserBo.getIntroduce() );
        authUser.setExtJson( authUserBo.getExtJson() );
        authUser.setIsDeleted( authUserBo.getIsDeleted() );

        return authUser;
    }
}
