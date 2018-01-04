package com.github.plei.modules.sys.service.impl;

import com.github.plei.common.annotation.DataFilter;
import com.github.plei.modules.sys.dao.SysRoleDao;
import com.github.plei.modules.sys.entity.SysRoleEntity;
import com.github.plei.modules.sys.service.SysRoleDeptService;
import com.github.plei.modules.sys.service.SysRoleMenuService;
import com.github.plei.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author : pleier
 * @date: 2017/12/11
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    @Qualifier("sysRoleDao")
    private SysRoleDao sysRoleDao;

    @Autowired
    @Qualifier("sysRoleMenuService")
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    @Qualifier("sysRoleDeptService")
    private SysRoleDeptService sysRoleDeptService;

    @Override
    public SysRoleEntity queryObject(Long roleId) {
        return sysRoleDao.queryObject(roleId);
    }

    @Override
    @DataFilter(tableAlias = "r", user = false)
    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return sysRoleDao.queryList(map);
    }

    @Override
    @DataFilter(tableAlias = "r", user = false)
    public int queryTotal(Map<String, Object> map) {
        return sysRoleDao.queryTotal();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleEntity role) {
        role.setCreateTime(new Date());
        sysRoleDao.save(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        sysRoleDao.update(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        sysRoleDao.deleteBatch(roleIds);
    }
}
