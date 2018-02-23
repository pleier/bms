package com.github.plei.common.utils;

/**
 * Redis使用的key
 *
 * @author : pleier
 * @date : 2018/1/8
 */
public class RedisKeys {

    /**
     * 获取sys:config:前缀的key
     *
     * @param key key
     * @return String
     */
    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }

    /**
     * 获取sessionid:前缀的key
     *
     * @param key key
     * @return String
     */
    public static String getShiroSessionKey(String key) {
        return "sessionid:" + key;
    }
}
