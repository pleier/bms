package com.github.plei.modules.sys.service.impl;

import com.github.plei.modules.sys.dao.SysRoleDeptDao;
import com.github.plei.modules.sys.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色与部门对应关系
 * @author : pleier
 * @date: 2017/12/11
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

    @Autowired
    @Qualifier("sysRoleDeptDao")
    private SysRoleDeptDao sysRoleDeptDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        //先删除角色与菜单关系
        sysRoleDeptDao.delete(roleId);

        if (deptIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>(16);
        map.put("roleId", roleId);
        map.put("deptIdList", deptIdList);
        sysRoleDeptDao.save(map);
    }

    @Override
    public List<Long> queryDeptIdList(Long roleId) {
        return sysRoleDeptDao.queryDeptIdList(roleId);
    }
}
