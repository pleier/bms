package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 角色与用户对应关系
 *
 * @author : pleier
 * @date: 2017/11/29
 */
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     *
     * @param userId
     * @return
     */
    List<Long> queryRoleIdList(Long userId);
}
