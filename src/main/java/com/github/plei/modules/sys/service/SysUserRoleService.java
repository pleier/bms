package com.github.plei.modules.sys.service;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysUserRoleService {

    /**
     * 保存或者更新
     *
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     *
     * @param userId
     * @return
     */
    List<Long> queryRoleIdList(Long userId);

    /**
     * 删除
     *
     * @param userId
     */
    void delete(Long userId);
}
