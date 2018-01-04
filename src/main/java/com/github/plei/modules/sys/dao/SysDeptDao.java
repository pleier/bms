package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysDeptEntity;

import java.util.List;

/**
 * 部门管理
 *
 * @author : pleier
 * @date: 2017/12/8
 */
public interface SysDeptDao extends BaseDao<SysDeptEntity> {
    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     * @return
     */
    List<Long> queryDetpIdList(Long parentId);
}
