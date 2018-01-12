package com.github.plei.modules.sys.controller;

import com.github.plei.common.utils.Constant;
import com.github.plei.common.utils.Result;
import com.github.plei.modules.sys.entity.SysDeptEntity;
import com.github.plei.modules.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 部门管理
 *
 * @author : pleier
 * @date : 2017/12/11
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {
    @Autowired
    @Qualifier("sysDeptService")
    private SysDeptService sysDeptService;

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public List<SysDeptEntity> list() {
        return sysDeptService.queryList(new HashMap<>(16));
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public Result select() {
        List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<>(16));

        //添加一级部门
        if (getUserId() == Constant.SUPER_ADMIN) {
            SysDeptEntity root = new SysDeptEntity();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            deptList.add(root);
        }

        return Result.ok().put("deptList", deptList);
    }

    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public Result info() {
        long deptId = 0;
        if (getUserId() != Constant.SUPER_ADMIN) {
            SysDeptEntity dept = sysDeptService.queryObject(getDeptId());
            deptId = dept.getParentId();
        }

        return Result.ok().put("deptId", deptId);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public Result info(@PathVariable("deptId") Long deptId) {
        SysDeptEntity dept = sysDeptService.queryObject(deptId);
        return Result.ok().put("dept", dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public Result save(@RequestBody SysDeptEntity dept) {
        sysDeptService.save(dept);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public Result delete(long deptId) {
        //判断是否有子部门
        List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
        if (deptList.size() > 0) {
            return Result.error("请先删除子部门");
        }
        sysDeptService.delete(deptId);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public Result update(@RequestBody SysDeptEntity dept){
        sysDeptService.update(dept);
        return Result.ok();
    }
}
