package com.github.plei.modules.job.service;

import com.github.plei.modules.job.entity.ScheduleJobLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 定时任务 日志
 *
 * @author : pleier
 * @date : 2018/1/10
 */
public interface ScheduleJobLogService {

    /**
     * 根据ID查询定时任务日志
     *
     * @param jobId 任务id
     * @return
     */
    ScheduleJobLogEntity queryObject(Long jobId);

    /**
     * 查询定时任务日志列表
     *
     * @param map
     * @return
     */
    List<ScheduleJobLogEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存定时任务日志
     *
     * @param log
     */
    void save(ScheduleJobLogEntity log);
}
