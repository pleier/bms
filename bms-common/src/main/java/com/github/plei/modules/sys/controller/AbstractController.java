package com.github.plei.modules.sys.controller;

import com.github.plei.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共组件
 *
 * @author : pleier
 * @date: 2017/11/29
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前用户
     *
     * @return
     */
    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前用户Id
     *
     * @return
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 获取当前用户部门Id
     *
     * @return
     */
    protected Long getDeptId() {
        return getUser().getDeptId();
    }
}
