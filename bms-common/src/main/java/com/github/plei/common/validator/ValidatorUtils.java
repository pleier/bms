package com.github.plei.common.validator;

import com.github.plei.common.exception.BmsException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * <p>
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author : pleier
 * @date: 2017/12/11
 */
public class ValidatorUtils {

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws BmsException 校验不通过，则报BmsException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws BmsException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>) constraintViolations.iterator().next();
            throw new BmsException(constraint.getMessage());
        }
    }
}
