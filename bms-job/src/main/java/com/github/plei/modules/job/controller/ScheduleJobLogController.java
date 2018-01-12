package com.github.plei.modules.job.controller;

import com.github.plei.common.utils.PageUtils;
import com.github.plei.common.utils.Query;
import com.github.plei.common.utils.Result;
import com.github.plei.modules.job.entity.ScheduleJobLogEntity;
import com.github.plei.modules.job.service.ScheduleJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 定时任务 日志
 *
 * @author : pleier
 * @date : 2018/1/10
 */
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController {

    @Autowired
    @Qualifier("scheduleJobLogService")
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 定时任务日志列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:log")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ScheduleJobLogEntity> jobList = scheduleJobLogService.queryList(query);
        int total = scheduleJobLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(jobList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 定时任务日志信息
     *
     * @param logId
     * @return
     */
    @RequestMapping("/info/{logId}")
    public Result info(@PathVariable("logId") Long logId) {
        ScheduleJobLogEntity log = scheduleJobLogService.queryObject(logId);

        return Result.ok().put("log", log);
    }
}
