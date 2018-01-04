package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单管理
 *
 * @author pleier
 */
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     * @return 系统菜单集合
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     *
     * @return 不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     *
     * @param userId 用户id
     * @return 用户菜单列表
     */
    List<SysMenuEntity> queryUserList(Long userId);
}
