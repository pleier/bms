package com.github.plei.common.aspect;

import com.github.plei.common.exception.BmsException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Redis切面处理类
 * @author : pleier
 * @date : 2018/1/8
 */
@Aspect
@Component
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 是否开启redis缓存  true开启   false关闭
     */
    @Value("${redis.open: false}")
    private boolean open;

    @Around("execution(* com.github.plei.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception e){
                logger.error("redis error", e);
                throw new BmsException("Redis服务异常");
            }
        }
        return result;
    }
}
