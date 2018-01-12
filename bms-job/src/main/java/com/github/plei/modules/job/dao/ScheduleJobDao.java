package com.github.plei.modules.job.dao;

import com.github.plei.modules.job.entity.ScheduleJobEntity;
import com.github.plei.modules.sys.dao.BaseDao;

import java.util.Map;

/**
 * 定时任务
 *
 * @author : pleier
 * @date : 2018/1/9
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {

    /**
     * 批量更新状态
     * @param map
     * @return
     */
    int updateBatch(Map<String, Object> map);
 }
