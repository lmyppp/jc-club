package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthPermissionDTOConverter;
import com.jingdianjichi.auth.application.convert.AuthRolePermissionDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBo;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色权限关联
 */
@RestController
@RequestMapping("/rolePermission")
@Slf4j
public class RolePermissionController {

    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;

    @RequestMapping("/addRolePermission")
    public Result<Boolean> addRolePermission(@RequestBody AuthRolePermissionDTO authRolePermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RolePermissionController.addRolePermission.dto:{}", JSON.toJSONString(authRolePermissionDTO));
            }
            Preconditions.checkNotNull(authRolePermissionDTO.getPermissionIdList(), "权限id不能为空");
            Preconditions.checkNotNull(authRolePermissionDTO.getRoleId(), "角色id不能为空");

            AuthRolePermissionBo authRolePermissionBo = AuthRolePermissionDTOConverter.INSTANCE
                    .convertRolePermissionDTOToBo(authRolePermissionDTO);

            return Result.ok(authRolePermissionDomainService.addRolePermission(authRolePermissionBo));
        } catch (Exception e) {
            log.info("RolePermissionController.addRolePermission.error:{}", e.getMessage(), e);
            return Result.fail("添加角色权限关联失败");
        }
    }


}
