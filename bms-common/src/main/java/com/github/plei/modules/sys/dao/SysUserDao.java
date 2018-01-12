package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户管理
 *
 * @author pleier
 */
public interface SysUserDao extends BaseDao<SysUserEntity> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username
     * @return 用户实体
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 修改密码
     *
     * @param map
     * @return 修改成功的数量
     */
    int updatePassword(Map<String, Object> map);
}
