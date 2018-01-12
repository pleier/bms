package com.github.plei.modules.sys.controller;

import com.github.plei.common.annotation.SysLog;
import com.github.plei.common.utils.PageUtils;
import com.github.plei.common.utils.Query;
import com.github.plei.common.utils.Result;
import com.github.plei.common.validator.ValidatorUtils;
import com.github.plei.modules.sys.entity.SysConfigEntity;
import com.github.plei.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 * @author : pleier
 * @date: 2017/12/19
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {

    @Autowired
    @Qualifier("sysConfigService")
    private SysConfigService sysConfigService;

    /**
     * 所有配置列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysConfigEntity> configList = sysConfigService.queryList(query);
        int total = sysConfigService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(configList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 配置信息详细
     *
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public Result info(@PathVariable("id") Long id) {
        SysConfigEntity entity = sysConfigService.queryObject(id);

        return Result.ok().put("config", entity);
    }

    @SysLog("保存配置")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public Result save(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.save(config);

        return Result.ok();
    }

    /**
     * 修改
     *
     * @param config
     * @return
     */
    @SysLog("修改配置")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public Result update(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);
        sysConfigService.update(config);
        return Result.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @SysLog("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public Result delete(@RequestBody Long[] ids) {
        sysConfigService.deleteBatch(ids);
        return Result.ok();
    }
}
