package com.github.plei.modules.job.controller;

import com.github.plei.common.annotation.SysLog;
import com.github.plei.common.utils.PageUtils;
import com.github.plei.common.utils.Query;
import com.github.plei.common.utils.Result;
import com.github.plei.common.validator.ValidatorUtils;
import com.github.plei.modules.job.entity.ScheduleJobEntity;
import com.github.plei.modules.job.service.ScheduleJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author : pleier
 * @date : 2018/1/9
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {

    @Autowired
    @Qualifier("scheduleJobService")
    private ScheduleJobService scheduleJobService;

    /**
     * 定时任务列表
     *
     * @param params params
     * @return Result
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ScheduleJobEntity> jobList = scheduleJobService.queryList(query);
        int total = scheduleJobService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(jobList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 定时任务信息
     *
     * @param jobId jobId
     * @return Result
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public Result info(@PathVariable("jobId") Long jobId) {
        ScheduleJobEntity schedule = scheduleJobService.queryObject(jobId);

        return Result.ok().put("schedule", schedule);
    }

    /**
     * 保存定时任务
     *
     * @param scheduleJob scheduleJob
     * @return Result
     */
    @SysLog("保存定时任务")
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public Result save(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.save(scheduleJob);

        return Result.ok();
    }

    /**
     * 修改定时任务
     *
     * @param scheduleJob scheduleJob
     * @return Result
     */
    @SysLog("修改定时任务")
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public Result update(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.update(scheduleJob);

        return Result.ok();
    }

    /**
     * 删除定时任务
     *
     * @param jobIds jobIds
     * @return Result
     */
    @SysLog("删除定时任务")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public Result delete(@RequestBody Long[] jobIds) {
        scheduleJobService.deleteBatch(jobIds);

        return Result.ok();
    }

    /**
     * 立即执行任务
     *
     * @param jobIds jobIds
     * @return Result
     */
    @SysLog("立即执行任务")
    @RequestMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public Result run(@RequestBody Long[] jobIds) {
        scheduleJobService.run(jobIds);

        return Result.ok();
    }

    /**
     * 暂停定时任务
     *
     * @param jobIds jobIds
     * @return Result
     */
    @SysLog("暂停定时任务")
    @RequestMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public Result pause(@RequestBody Long[] jobIds) {
        scheduleJobService.pause(jobIds);

        return Result.ok();
    }

    /**
     * 恢复定时任务
     *
     * @param jobIds jobIds
     * @return Result
     */
    @SysLog("恢复定时任务")
    @RequestMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public Result resume(@RequestBody Long[] jobIds) {
        scheduleJobService.resume(jobIds);

        return Result.ok();
    }
}
