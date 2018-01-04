package com.github.plei.modules.sys.service;

import java.util.List;

/**
 * 角色与菜单对应关系
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysRoleMenuService {

    /**
     * 保存或者修改
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);


    /**
     * 根据角色ID，获取菜单ID列表
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdList(Long roleId);
}
