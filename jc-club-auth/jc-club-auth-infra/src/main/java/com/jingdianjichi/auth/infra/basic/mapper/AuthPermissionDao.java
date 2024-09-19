package com.jingdianjichi.auth.infra.basic.mapper;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AuthPermission)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-08 19:14:19
 */
public interface AuthPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthPermission queryById(Integer id);

    /**
     * 查询指定行数据
     *

     */
    AuthPermission queryAllByLimit(AuthPermission authPermission);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param authPermission 实例对象
     * @return 对象列表
     */
    List<AuthPermission> queryAll(AuthPermission authPermission);

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 影响行数
     */
    int insert(AuthPermission authPermission);

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 影响行数
     */
    int update(AuthPermission authPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据角色idList查询权限
     * @param permissionIdList
     * @return
     */
    List<AuthPermission> queryByPermissionIdList(@Param("list") List<Integer> permissionIdList);
}