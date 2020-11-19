package com.linkedbear.spring.aop.g_weaving.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Component
@Aspect
public class LogAspect {
    
    @Around("pointcut()")
    public Object beforePrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAspect 前置通知 ......");
        return joinPoint.proceed();
    }
    
    @Pointcut("execution(* com.linkedbear.spring.aop.g_weaving.service.UserService.*(..))")
    public void pointcut() {
    
    }
}
