package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthRoleDTOConverter;
import com.jingdianjichi.auth.application.convert.AuthUserDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.entity.AuthRoleBo;
import com.jingdianjichi.auth.domain.entity.AuthUserBo;
import com.jingdianjichi.auth.domain.service.AuthRoleDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Resource
    private AuthRoleDomainService authRoleDomainService;

    /**
     * 添加角色
     */
    @RequestMapping("/addRole")
    public Result<Boolean> addRole(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.addRole.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getRoleName(), "角色名称不能为空");
            Preconditions.checkNotNull(authRoleDTO.getRoleKey(), "角色唯一标识不能为空");

            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertRoleDTOToBo(authRoleDTO);

            return Result.ok(authRoleDomainService.addRole(authRoleBo));
        } catch (Exception e) {
            log.info("RoleController.addRole.error:{}", e.getMessage(), e);
            return Result.fail("添加角色失败");
        }
    }

    /**
     * 修改角色
     */
    @RequestMapping("/updateRole")
    public Result<Boolean> updateRole(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.updateRole.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getRoleName(), "角色名称不能为空");
            Preconditions.checkNotNull(authRoleDTO.getRoleKey(), "角色唯一标识不能为空");

            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertRoleDTOToBo(authRoleDTO);

            return Result.ok(authRoleDomainService.updateRole(authRoleBo));
        } catch (Exception e) {
            log.info("RoleController.updateRole.error:{}", e.getMessage(), e);
            return Result.fail("修改角色失败");
        }
    }

    /**
     * 修改角色
     */
    @RequestMapping("/deleteRole")
    public Result<Boolean> deleteRole(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.deleteRole.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            Preconditions.checkNotNull(authRoleDTO.getId(), "id不能为空");

            AuthRoleBo authRoleBo = AuthRoleDTOConverter.INSTANCE.convertRoleDTOToBo(authRoleDTO);

            return Result.ok(authRoleDomainService.deleteRole(authRoleBo));
        } catch (Exception e) {
            log.info("RoleController.deleteRole.error:{}", e.getMessage(), e);
            return Result.fail("删除角色失败");
        }
    }


}
