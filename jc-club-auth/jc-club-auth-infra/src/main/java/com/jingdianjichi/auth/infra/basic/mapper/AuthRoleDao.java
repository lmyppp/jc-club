package com.jingdianjichi.auth.infra.basic.mapper;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AuthRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-08 00:58:21
 */
public interface AuthRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Integer id);

    /**
     * 查询指定行数据
     */
    AuthRole queryAllByLimit(AuthRole authRole);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param authRole 实例对象
     * @return 对象列表
     */
    List<AuthRole> queryAll(AuthRole authRole);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 影响行数
     */
    int insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 影响行数
     */
    int update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据roleIdList查询AuthRole
     * @param roleIdList
     * @return
     */
    List<AuthRole> queryByRoleList(@Param("list") List<Integer> roleIdList);
}