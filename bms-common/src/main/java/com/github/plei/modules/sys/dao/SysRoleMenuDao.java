package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * 角色与菜单对应关系
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {

    /**
     * 根据角色ID，获取菜单ID列表
     *
     * @param roleId
     * @return 菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);

}
