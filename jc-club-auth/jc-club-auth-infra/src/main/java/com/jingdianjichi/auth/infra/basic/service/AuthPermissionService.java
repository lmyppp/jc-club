package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import java.util.List;

/**
 * (AuthPermission)表服务接口
 *
 * @author makejava
 * @since 2023-11-08 19:14:20
 */
public interface AuthPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthPermission queryById(Integer id);

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer insert(AuthPermission authPermission);

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer update(AuthPermission authPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据条件查询
     * @param authPermission
     * @return
     */
    AuthPermission queryByCondition(AuthPermission authPermission);

    /**
     * 根据角色idList查询权限
     * @param PermissionIdList
     * @return
     */
    List<AuthPermission> queryByPermissionIdList(List<Integer> PermissionIdList);
}