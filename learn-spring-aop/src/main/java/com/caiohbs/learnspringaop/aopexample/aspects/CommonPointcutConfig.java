package com.caiohbs.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.caiohbs.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackagesConfig() {}

    @Pointcut("execution(* com.caiohbs.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.caiohbs.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.caiohbs.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}

}
