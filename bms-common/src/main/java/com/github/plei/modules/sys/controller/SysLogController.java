package com.github.plei.modules.sys.controller;

import com.github.plei.common.utils.PageUtils;
import com.github.plei.common.utils.Query;
import com.github.plei.common.utils.Result;
import com.github.plei.modules.sys.entity.SysLogEntity;
import com.github.plei.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 * @author : pleier
 * @date: 2017/12/14
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController {

    @Autowired
    @Qualifier("sysLogService")
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysLogEntity> sysLogList = sysLogService.queryList(query);
        int total = sysLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

}
