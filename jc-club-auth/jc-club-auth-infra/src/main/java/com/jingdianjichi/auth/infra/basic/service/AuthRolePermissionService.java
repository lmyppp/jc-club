package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import java.util.List;

/**
 * (AuthRolePermission)表服务接口
 *
 * @author makejava
 * @since 2023-11-08 20:16:44
 */
public interface AuthRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Integer id);

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    Integer insert(AuthRolePermission authRolePermission);

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 循环插入数据库
      * @param authRolePermissionList
     * @return
     */
    Integer batchInsert(List<AuthRolePermission> authRolePermissionList);

    /**
     * 根据条件查询角色权限关联表
     * @param authRolePermission
     * @return
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);

}