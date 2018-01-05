package com.github.plei.common.validator;

import com.github.plei.common.exception.BmsException;
import org.apache.commons.lang.StringUtils;

/**
 * 数具校验
 *
 * @author : pleier
 * @date: 2017/12/8
 */
public abstract class AbstractAssert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BmsException(message);
        }
    }

}
