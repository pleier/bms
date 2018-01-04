package com.github.plei.modules.sys.controller;

import com.github.plei.common.annotation.SysLog;
import com.github.plei.common.exception.BmsException;
import com.github.plei.common.utils.Constant;
import com.github.plei.common.utils.Result;
import com.github.plei.modules.sys.entity.SysMenuEntity;
import com.github.plei.modules.sys.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static com.github.plei.modules.sys.shiro.ShiroUtils.getUserId;

/**
 * 系统菜单
 *
 * @author : pleier
 * @date: 2017/11/29
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Autowired
    @Qualifier("sysMenuService")
    private SysMenuService sysMenuService;

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public Result nav() {
        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
        return Result.ok().put("menuList", menuList);
    }

    /**
     * 所有菜单列表
     *
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenuEntity> list() {
        List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<>(16));
        return menuList;
    }

    /**
     * 选择菜单（添加、修改菜单）
     *
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public Result select() {
        //查询列表数据
        List<SysMenuEntity> menuList = sysMenuService.queryNotButtonList();

        //添加顶级菜单
        SysMenuEntity root = new SysMenuEntity();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
        root.setOpen(true);
        menuList.add(root);

        return Result.ok().put("menuList", menuList);
    }

    /**
     * 菜单信息
     *
     * @param menuId
     * @return
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public Result info(@PathVariable("menuId") Long menuId) {
        SysMenuEntity menu = sysMenuService.queryObject(menuId);
        return Result.ok().put("menu", menu);
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
    @SysLog("保存菜单")
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public Result save(@RequestBody SysMenuEntity menu) {
        //数据校验
        verifyForm(menu);
        sysMenuService.save(menu);
        return Result.ok();
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
    @SysLog("修改菜单")
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public Result update(@RequestBody SysMenuEntity menu) {
        //数据校验
        verifyForm(menu);
        sysMenuService.update(menu);
        return Result.ok();
    }

    @SysLog("删除菜单")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public Result delete(long menuId) {
        int max = 31;
        if (menuId <= max) {
            return Result.error("系统菜单，不能删除");
        }

        //判断是否有子菜单或按钮
        List<SysMenuEntity> menuList = sysMenuService.queryListParentId(menuId);
        if (menuList.size() > 0) {
            return Result.error("请先删除子菜单或按钮");
        }

        sysMenuService.deleteBatch(new Long[]{menuId});

        return Result.ok();
    }

    /**
     * 验证参数是否正确
     *
     * @param menu
     */
    private void verifyForm(SysMenuEntity menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new BmsException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new BmsException("上级菜单不能为空");
        }

        //菜单
        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new BmsException("菜单URL不能为空");
            }
        }

        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenuEntity parentMenu = sysMenuService.queryObject(menu.getParentId());
            parentType = parentMenu.getType();
        }

        //目录、菜单
        if (menu.getType() == Constant.MenuType.CATALOG.getValue() ||
                menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new BmsException("上级菜单只能为目录类型");
            }
            return;
        }

        //按钮
        if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new BmsException("上级菜单只能为菜单类型");
            }
            return;
        }
    }
}
