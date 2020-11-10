package com.linkedbear.spring.aop.d_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class LogAspect {
    
    @Before("execution(* com.linkedbear.spring.aop.d_order.service.UserService.*(..))")
    public void printLog() {
        System.out.println("LogAspect 打印日志 ......");
    }
}
