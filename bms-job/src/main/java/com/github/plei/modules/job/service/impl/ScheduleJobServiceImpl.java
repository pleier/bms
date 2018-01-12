package com.github.plei.modules.job.service.impl;

import com.github.plei.modules.job.dao.ScheduleJobDao;
import com.github.plei.modules.job.entity.ScheduleJobEntity;
import com.github.plei.modules.job.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author : pleier
 * @date : 2018/1/9
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {

   /* @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;*/

    @Autowired
    @Qualifier("scheduleJobDao")
    private ScheduleJobDao scheduleJobDao;

    /**
     * 项目启动时，初始化定时器
     */
   /* @PostConstruct
    public void init(){
        List<ScheduleJobEntity> scheduleJobList = schedulerJobDao.queryList(new HashMap<>(16));
        for(ScheduleJobEntity scheduleJob : scheduleJobList){
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            }else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }*/

    @Override
    public ScheduleJobEntity queryObject(Long jobId) {
        return scheduleJobDao.queryObject(jobId);
    }

    @Override
    public List<ScheduleJobEntity> queryList(Map<String, Object> map) {
        return scheduleJobDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return scheduleJobDao.queryTotal(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ScheduleJobEntity scheduleJob) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ScheduleJobEntity scheduleJob) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] jobIds) {

    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resume(Long[] jobIds) {

    }
}
