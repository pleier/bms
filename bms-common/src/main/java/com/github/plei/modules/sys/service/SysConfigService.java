package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 * @author : pleier
 * @date: 2017/12/15
 */
public interface SysConfigService {

    /**
     * 保存配置信息
     *
     * @param config
     */
    void save(SysConfigEntity config);

    /**
     * 更新配置信息
     *
     * @param config
     */
    void update(SysConfigEntity config);

    /**
     * 根据key，更新value
     *
     * @param key
     * @param value
     */
    void updateValueByKey(String key, String value);

    /**
     * 删除配置信息
     *
     * @param ids
     */
    void deleteBatch(Long[] ids);

    /**
     * 获取List列表
     *
     * @param map
     * @return
     */
    List<SysConfigEntity> queryList(Map<String, Object> map);

    /**
     * 获取总记录数
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    SysConfigEntity queryObject(Long id);

    /**
     * 根据key，获取配置的value值
     *
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 根据key，获取value的Object对象
     *
     * @param key   key
     * @param clazz Object对象
     * @param <T>
     * @return
     */
    <T> T getConfigObject(String key, Class<T> clazz);
}
