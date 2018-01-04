package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 * @author : pleier
 * @date: 2017/12/14
 */
public interface SysLogService {

    /**
     * 查询
     *
     * @param id
     * @return
     */
    SysLogEntity queryObject(Long id);

    /**
     * 查询列表
     *
     * @param map
     * @return
     */
    List<SysLogEntity> queryList(Map<String, Object> map);

    /**
     * 统计
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     *
     * @param sysLog
     */
    void save(SysLogEntity sysLog);

    /**
     * 修改
     *
     * @param sysLog
     */
    void update(SysLogEntity sysLog);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(Long[] ids);
}
