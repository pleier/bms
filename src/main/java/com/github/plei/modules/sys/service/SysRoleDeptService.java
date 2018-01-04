package com.github.plei.modules.sys.service;

import java.util.List;

/**
 * 角色与部门对应关系
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysRoleDeptService {
    /**
     * 保存或修改
     * @param roleId
     * @param deptIdList
     */
    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    /**
     * 根据角色ID，获取部门ID列表
     * @param roleId
     * @return
     */
    List<Long> queryDeptIdList(Long roleId);
}
