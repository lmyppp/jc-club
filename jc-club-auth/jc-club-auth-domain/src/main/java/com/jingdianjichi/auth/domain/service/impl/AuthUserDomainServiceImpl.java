package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.google.gson.Gson;
import com.jingdianjichi.auth.common.enums.AuthUserStatusEnum;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.constants.AuthConstant;
import com.jingdianjichi.auth.domain.convert.AuthUserBOConverter;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.infra.basic.entity.*;
import com.jingdianjichi.auth.infra.basic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("AuthUserDomainService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";

    //对称加密公钥
    private String key = "123456";


    @Override
    public Boolean register(AuthUserBo authUserBo) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBo);
        //md5加密（摘要加密）
        //authUser.setPassword(SaSecureUtil.md5(authUserBo.getPassword()));

        /*
        扩展：加密加盐
        盐：是一个随机的字符串。它与原密码进行一波二次加密。
         */
        authUser.setPassword(SaSecureUtil.md5BySalt(authUserBo.getPassword(), "ppppp"));

        //对称加密,密钥加密，密钥解密
//        authUser.setPassword(SaSecureUtil.aesEncrypt(authUserBo.getPassword(),key));
        //对称解密
        //SaSecureUtil.aesDecrypt(authUserBo.getPassword(),key));

        //非对称加密,不在代码里生成，一般在其他地方生成两个key。再对密码进行加密。公钥加密，私钥解密，或者反过来
        /*try {
            HashMap<String, String> keyPair = SaSecureUtil.rsaGenerateKeyPair();
            String privateKey = keyPair.get("private");
            String publicKey = keyPair.get("public");
            SaSecureUtil.rsaEncryptByPublic(publicKey,authUserBo.getPassword());
            SaSecureUtil.rsaDecryptByPrivate(privateKey,authUserBo.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        int count = authUserService.insert(authUser);

        //建立一个初步的用户角色关联
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);
        Integer roleId = roleResult.getId();
        Integer userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        authUserRoleService.insert(authUserRole);

        //把当前用户的角色和权限都存储到redis
        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(roleId);
        List<AuthRolePermission> authRolePermissionList = authRolePermissionService
                .queryByCondition(authRolePermission);

        List<Integer> PermissionIdList =
                authRolePermissionList.stream().map(rolePermission -> {
            return rolePermission.getPermissionId();
        }).collect(Collectors.toList());
        //根据permissionId查权限
        List<AuthPermission> permissionList = authPermissionService.queryByPermissionIdList(PermissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey,new Gson().toJson(permissionList));

        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBo authUserBo) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBo);
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        int count = authUserService.update(authUser);
        //有更新，与缓存同步
        return count > 0;
    }

    @Override
    public void delete(AuthUserBo authUserBo) {
        AuthUser authUserId = new AuthUser();
        authUserId.setId(authUserBo.getId());
        authUserId.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        authUserService.update(authUserId);
    }

    @Override
    public Boolean changeStatus(AuthUserBo authUserBo) {
        AuthUser authUserStatus = new AuthUser();
        authUserStatus.setId(authUserBo.getId());
        authUserStatus.setStatus(authUserBo.getStatus());
        int count = authUserService.update(authUserStatus);
        return count > 0;
    }
}
