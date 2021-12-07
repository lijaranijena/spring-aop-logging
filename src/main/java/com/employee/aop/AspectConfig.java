package com.employee.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
@Order(0)
public class AspectConfig {

    @Around("@annotation(com.employee.aop.BoundaryLogger)")
    public Object boundaryLoggerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        Long endTime = System.nanoTime();
        long elapseTime = endTime - startTime;
        if (logger.isDebugEnabled()) {
            logger.debug("Class:{},method:{} has taken {} millis", className, methodName, TimeUnit.NANOSECONDS.toMillis(elapseTime));
        }
        return result;
    }
}
