package com.linkedbear.spring.aop.d_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect implements Ordered {
    
    @Before("execution(* com.linkedbear.spring.aop.d_order.service.UserService.*(..))")
    public void beginTransaction() {
        System.out.println("TransactionAspect 开启事务 ......");
    }
    
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
