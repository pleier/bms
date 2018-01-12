package com.github.plei.modules.sys.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础dao
 *
 * @param <T>
 * @author pleier
 */
public interface BaseDao<T> {

    /**
     * 保存实体
     *
     * @param t
     */
    void save(T t);

    /**
     * 保存
     *
     * @param map
     */
    void save(Map<String, Object> map);

    /**
     * 批量保存
     *
     * @param list
     */
    void saveBatch(List<T> list);

    /***
     * 更新实体
     * @param t
     * @return 更新成功的条数
     */
    int update(T t);

    /**
     * 更新实体某些信息
     *
     * @param map
     * @return 更新成功条数
     */
    int update(Map<String, Object> map);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 删除的条数
     */
    int delete(Object id);

    /**
     * 根据某些信息删除
     *
     * @param map
     * @return
     */
    int delete(Map<String, Object> map);

    /**
     * 根据主键批量删除
     *
     * @param id 主键
     * @return
     */
    int deleteBatch(Object[] id);

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return
     */
    T queryObject(Object id);

    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    List<T> queryList(Map<String, Object> map);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    List<T> queryList(Object id);

    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 统计所有数据的数量
     *
     * @return 数据条数
     */
    int queryTotal();
}
