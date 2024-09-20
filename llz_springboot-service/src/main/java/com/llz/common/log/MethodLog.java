package com.llz.common.log;

import java.lang.annotation.*;

/**
 * 自定义注解, 作用在方法上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodLog {
}
