package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;

import java.util.List;

/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2023-11-08 00:58:25
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Integer id);

    /**
     * 查询多条数据
     */
    AuthRole queryAllByLimit(AuthRole authRole);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Integer insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Integer update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据条件查询角色
     * @param authRole
     * @return
     */
    AuthRole queryByCondition(AuthRole authRole);

    /**
     * 根据roleIdList查询AuthRole
     * @param roleIdList
     * @return
     */
    List<AuthRole> queryByRoleList(List<Integer> roleIdList);
}