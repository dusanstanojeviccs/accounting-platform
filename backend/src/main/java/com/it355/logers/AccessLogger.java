package com.it355.logers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AccessLogger {
    @Pointcut("execution(* com.it355.dao.*.*(..))")
    public void daoAll() {}

    @Pointcut("execution(* com.it355.models.*.*(..))")
    public void modelAll() {}

    @Before("daoAll()")
    public void beforeDaoAll() {
        System.out.println("Accessing DAO");
    }

    @Before("modelAll()")
    public void beforeModelAll() {
        System.out.println("Accessing Model");
    }
}
