package com.github.plei.modules.sys.service;

import com.github.plei.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * @author : pleier
 * @date: 2017/11/29
 */
public interface SysUserService {

    /**
     * 查询用户所有权限
     * @param userId 用户id
     * @return
     */
    List<String> queryAllPerms(Long userId);

    /**
     *查询用户的所有菜单
     * @param userId 用户id
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名查询系统用户
     * @param username 用户名
     * @return
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 根据用户id查询用户
     * @param userId 用户id
     * @return
     */
    SysUserEntity queryObject(Long userId);

    /**
     * 查询用户列表
     * @param map
     * @return
     */
    List<SysUserEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);


    /**
     * 保存用户
     * @param user
     */
    void save(SysUserEntity user);

    /**
     * 修改用户
     * @param user
     */
    void update(SysUserEntity user);

    /**
     * 批量删除
     * @param userIds
     */
    void deleteBatch(Long[] userIds);


    /**
     * 修改密码
     * @param userId 用户id
     * @param password 原密码
     * @param newPassword 新密码
     * @return
     */
    int updatePassword(Long userId, String password, String newPassword);
}
