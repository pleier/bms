package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysRoleService {

    /**
     * 根据id查询
     *
     * @param roleId
     * @return
     */
    SysRoleEntity queryObject(Long roleId);

    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    List<SysRoleEntity> queryList(Map<String, Object> map);

    /**
     * 查询 符合条件的数据数量
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     *
     * @param role
     */
    void save(SysRoleEntity role);

    /**
     * 修改
     *
     * @param role
     */
    void update(SysRoleEntity role);

    /**
     * 删除
     *
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);
}
