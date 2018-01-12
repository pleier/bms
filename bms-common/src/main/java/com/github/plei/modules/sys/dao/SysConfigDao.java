package com.github.plei.modules.sys.dao;

import com.github.plei.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 *
 * @author : pleier
 * @date: 2017/12/15
 */
public interface SysConfigDao extends BaseDao<SysConfigEntity> {

    /**
     * 根据key查询value
     *
     * @param paramKey
     * @return
     */
    SysConfigEntity queryByKey(String paramKey);

    /**
     * 根据key更新value
     *
     * @param key
     * @param value
     * @return
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);
}
