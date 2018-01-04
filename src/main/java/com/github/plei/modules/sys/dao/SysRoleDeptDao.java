package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysRoleDeptEntity;

import java.util.List;

/**
 * 角色与部门对应关系
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysRoleDeptDao extends BaseDao<SysRoleDeptEntity> {


    /**
     * 根据角色ID，获取部门ID列表
     *
     * @param roleId
     * @return 部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);
}
