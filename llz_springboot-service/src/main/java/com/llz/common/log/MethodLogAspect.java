package com.llz.common.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP切面写日志
 */
@Aspect
@Component
@Slf4j
public class MethodLogAspect {

    /**
     * 自定义注解的切点
     */
    @Pointcut("@annotation(com.llz.common.log.MethodLog)")
    public void methodLog() {

    }

    @Before("methodLog()")
    public void doBefore(JoinPoint joinPoint) {
        //记录方法入参的日志打印
        log.info("Request Method: {},Request Param: {}", joinPoint.getSignature() ,JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "o" , pointcut = "methodLog()")
    public void doBefore(Object o) {
        //记录方法的返回日志
        log.info("Response Result:{}",JSON.toJSONString(o));
    }

}
