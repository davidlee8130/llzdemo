package com.llz.common.util.enumValidate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * 自定义校验器(校验参数是否存在枚举中)
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<EnumValue, CharSequence> {

    private Enum<?>[] enumValues;
    private Method getCodeMethod;

    @Override
    public void initialize(EnumValue annotation) {
        Class<? extends Enum<?>> enumClass = annotation.enumClass();
        this.enumValues = enumClass.getEnumConstants();
        try {
            this.getCodeMethod = enumClass.getMethod("getCode");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Enum must have getCode and getName methods", e);
        }

    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        for (Enum<?> enumValue : enumValues) {
            try {
                String code = (String) getCodeMethod.invoke(enumValue);
                if (code.equals(value.toString())) {
                    return true;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error accessing enum fields", e);
            }
        }
        return false;
    }
}
