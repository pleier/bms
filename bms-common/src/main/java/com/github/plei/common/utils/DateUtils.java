package com.github.plei.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author : pleier
 * @date : 2018/1/9
 */
public class DateUtils {

    /**
     * 时间格式 yyyy-MM-dd
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd 格式
     *
     * @param date
     * @return 格式后的日期字符串
     */
    public static String formatDate(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * yyyy-MM-dd HH:mm:ss 格式
     *
     * @param date
     * @return 格式后的日期字符串
     */
    public static String formatDateTime(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 给定的格式
     *
     * @param date    日期
     * @param pattern 格式
     * @return 格式划后的日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
