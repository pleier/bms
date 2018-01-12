package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public interface SysDeptService {

    /**
     * 根据部门ID查询部门信息
     *
     * @param deptId
     * @return
     */
    SysDeptEntity queryObject(Long deptId);

    /**
     * 查询部门信息
     *
     * @param map
     * @return
     */
    List<SysDeptEntity> queryList(Map<String, Object> map);

    /**
     * 保存
     *
     * @param sysDept
     */
    void save(SysDeptEntity sysDept);

    /**
     * 修改
     *
     * @param sysDept
     */
    void update(SysDeptEntity sysDept);

    /**
     * 删除
     *
     * @param deptId
     */
    void delete(Long deptId);

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     * @return 部门ID列表
     */
    List<Long> queryDetpIdList(Long parentId);

    /**
     * 获取子部门ID(包含本部门ID)，用于数据过滤
     *
     * @param deptId
     * @return
     */
    String getSubDeptIdList(Long deptId);
}
