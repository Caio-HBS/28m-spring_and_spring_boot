package com.caiohbs.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info(
                "BEFORE ASPECT: {} is called with the following arguments: {}.",
                joinPoint, joinPoint.getArgs()
        );
    }

    @After("execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("AFTER ASPECT: {} has been executed.", joinPoint);
    }

    @AfterThrowing(
            pointcut="execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))",
            throwing="exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info(
                "AFTER THROWING ASPECT: {} has thrown an exception ({}).",
                joinPoint, exception.getMessage()
        );
    }

    @AfterReturning(
            pointcut="execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))",
            returning="resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info(
                "AFTER RETURNING ASPECT: {} has been executed successfully. Result is {}.",
                joinPoint, resultValue
        );
    }

}
