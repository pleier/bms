package com.github.plei.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @author : pleier
 * @date: 2017/12/8
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
