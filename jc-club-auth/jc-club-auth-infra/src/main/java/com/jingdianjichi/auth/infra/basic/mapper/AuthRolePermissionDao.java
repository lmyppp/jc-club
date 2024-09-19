package com.jingdianjichi.auth.infra.basic.mapper;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AuthRolePermission)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-08 20:16:41
 */
public interface AuthRolePermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<AuthRolePermission> queryAllByLimit(AuthRolePermission authRolePermission);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param authRolePermission 实例对象
     * @return 对象列表
     */
    List<AuthRolePermission> queryAll(AuthRolePermission authRolePermission);

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 影响行数
     */
    int insert(AuthRolePermission authRolePermission);

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 影响行数
     */
    int update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 循环插入数据
     * @param authRolePermissionList
     * @return
     */
    Integer batchInsert(@Param("authRolePermissionList") List<AuthRolePermission> authRolePermissionList);

}