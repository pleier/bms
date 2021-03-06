package com.github.plei.modules.job.service;

import com.github.plei.modules.job.entity.ScheduleJobEntity;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author : pleier
 * @date : 2018/1/9
 */
public interface ScheduleJobService {

    /**
     * 根据ID，查询定时任务
     *
     * @param jobId 任务ID
     * @return
     */
    ScheduleJobEntity queryObject(Long jobId);

    /**
     * 查询定时任务列表
     *
     * @param map
     * @return
     */
    List<ScheduleJobEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存定时任务
     *
     * @param scheduleJob
     */
    void save(ScheduleJobEntity scheduleJob);

    /**
     * 更新定时任务
     *
     * @param scheduleJob
     */
    void update(ScheduleJobEntity scheduleJob);

    /**
     * 批量删除定时任务
     *
     * @param jobIds
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     *
     * @param jobIds 任务ID
     * @param status
     * @return
     */
    int updateBatch(Long[] jobIds, int status);

    /**
     * 立即执行
     *
     * @param jobIds 任务ID
     */
    void run(Long[] jobIds);

    /**
     * 暂停运行
     *
     * @param jobIds 任务ID
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     *
     * @param jobIds 任务ID
     */
    void resume(Long[] jobIds);
}
