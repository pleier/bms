package com.github.plei.modules.sys.service.impl;

import com.github.plei.common.exception.BmsException;
import com.github.plei.modules.sys.dao.SysConfigDao;
import com.github.plei.modules.sys.entity.SysConfigEntity;
import com.github.plei.modules.sys.service.SysConfigService;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 * @author : pleier
 * @date: 2017/12/15
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    @Qualifier("sysConfigDao")
    private SysConfigDao sysConfigDao;

    @Override
    public void save(SysConfigEntity config) {
        sysConfigDao.save(config);
    }

    @Override
    public void update(SysConfigEntity config) {
        sysConfigDao.update(config);
    }

    @Override
    public void updateValueByKey(String key, String value) {
        sysConfigDao.updateValueByKey(key, value);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysConfigDao.deleteBatch(ids);
    }

    @Override
    public List<SysConfigEntity> queryList(Map<String, Object> map) {
        return sysConfigDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysConfigDao.queryTotal(map);
    }

    @Override
    public SysConfigEntity queryObject(Long id) {
        return sysConfigDao.queryObject(id);
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = sysConfigDao.queryByKey(key);

        return config == null ? null : config.getValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BmsException("获取参数失败");
        }
    }
}
