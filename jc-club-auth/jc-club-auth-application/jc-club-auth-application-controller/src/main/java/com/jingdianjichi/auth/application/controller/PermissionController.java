package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthPermissionDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBo;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permission")
@Slf4j
public class PermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    @RequestMapping("/addPermission")
    public Result<Boolean> addPermission(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.addPermission.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getName(), "权限名称不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "权限父id不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getPermissionKey(), "权限唯一标识不能为空");

            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE
                    .convertPermissionDTOToBo(authPermissionDTO);

            return Result.ok(authPermissionDomainService.addPermission(authPermissionBo));
        } catch (Exception e) {
            log.info("PermissionController.addPermission.error:{}", e.getMessage(), e);
            return Result.fail("添加权限失败");
        }
    }

    @RequestMapping("/updatePermission")
    public Result<Boolean> updatePermission(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.updatePermission.dto:{}", JSON.toJSONString(authPermissionDTO));
            }

            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE
                    .convertPermissionDTOToBo(authPermissionDTO);

            return Result.ok(authPermissionDomainService.updatePermission(authPermissionBo));
        } catch (Exception e) {
            log.info("PermissionController.updatePermission.error:{}", e.getMessage(), e);
            return Result.fail("修改权限失败");
        }
    }

    @RequestMapping("/deletePermission")
    public Result<Boolean> deletePermission(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.deletePermission.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");

            AuthPermissionBo authPermissionBo = AuthPermissionDTOConverter.INSTANCE
                    .convertPermissionDTOToBo(authPermissionDTO);

            return Result.ok(authPermissionDomainService.deletePermission(authPermissionBo));
        } catch (Exception e) {
            log.info("PermissionController.deletePermission.error:{}", e.getMessage(), e);
            return Result.fail("删除权限失败");
        }
    }
}
