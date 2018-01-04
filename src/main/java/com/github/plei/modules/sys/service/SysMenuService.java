package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * @author : pleier
 * @date: 2017/11/29
 */
public interface SysMenuService {

    /**
     *根据父菜单查询子菜单
     * @param parentId 父菜单id
     * @param menuIdList 用户菜单id
     * @return 菜单列表
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单查询子菜单
     * @param parentId 父菜单id
     * @return 菜单列表
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     * @return 菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     * @param userId 用户id
     * @return 菜单列表
     */
    List<SysMenuEntity> getUserMenuList(Long userId);

    /**
     * 查询菜单
     * @param menuId 菜单id
     * @return 菜单
     */
    SysMenuEntity queryObject(Long menuId);

    /**
     *查询菜单列表
     * @param map
     * @return
     */
    List<SysMenuEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存菜单
     * @param menu
     */
    void save(SysMenuEntity menu);

    /**
     * 修改菜单
     * @param menu
     */
    void update(SysMenuEntity menu);

    /**
     * 批量删除菜单
     * @param menuIds 菜单id
     */
    void deleteBatch(Long[] menuIds);

    /**
     * 查询用户的权限列表
     * @param userId 用户id
     * @return
     */
    List<SysMenuEntity> queryUserList(Long userId);

}
