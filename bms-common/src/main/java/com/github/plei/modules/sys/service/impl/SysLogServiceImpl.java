package com.github.plei.modules.sys.service.impl;

import com.github.plei.modules.sys.dao.SysLogDao;
import com.github.plei.modules.sys.entity.SysLogEntity;
import com.github.plei.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 * @author : pleier
 * @date: 2017/12/14
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    @Qualifier("sysLogDao")
    private SysLogDao sysLogDao;

    @Override
    public SysLogEntity queryObject(Long id) {
        return sysLogDao.queryObject(id);
    }

    @Override
    public List<SysLogEntity> queryList(Map<String, Object> map) {
        return sysLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysLogDao.queryTotal(map);
    }

    @Override
    public void save(SysLogEntity sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public void update(SysLogEntity sysLog) {
        sysLogDao.update(sysLog);
    }

    @Override
    public void delete(Long id) {
        sysLogDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysLogDao.deleteBatch(ids);
    }
}
