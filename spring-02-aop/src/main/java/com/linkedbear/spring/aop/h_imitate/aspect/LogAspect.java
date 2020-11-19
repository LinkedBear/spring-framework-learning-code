package com.linkedbear.spring.aop.h_imitate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    
    @Before("execution(* com.linkedbear.spring.aop.h_imitate.service.*.*(..))")
    public void beforePrint() {
        System.out.println("LogAspect beforePrint ......");
    }
}
