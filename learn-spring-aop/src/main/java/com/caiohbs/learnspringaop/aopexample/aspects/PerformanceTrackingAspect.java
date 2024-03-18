package com.caiohbs.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTime = System.currentTimeMillis();

        long executionDuration = stopTime - startTime;

        logger.info("AROUND ASPECT: {} Execution time was {} ms.", proceedingJoinPoint, executionDuration);

        return returnValue;
    }

}
