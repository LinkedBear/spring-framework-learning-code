package com.linkedbear.spring.aop.c_joinpoint.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    
    @Before("execution(public * com.linkedbear.spring.aop.c_joinpoint.service.FinanceService.addMoney(..))")
    public void beforePrint(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getTarget());
//        System.out.println(joinPoint.getThis().toString());
//        System.out.println(joinPoint.getTarget().getClass().getName());
//        System.out.println(joinPoint.getThis().getClass().getName());
    
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
    
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println(method.getName());
        
        System.out.println("Logger beforePrint run ......");
        System.out.println("被拦截的类：" + joinPoint.getTarget().getClass().getName());
        System.out.println("被拦截的方法：" + ((MethodSignature) joinPoint.getSignature()).getMethod().getName());
        System.out.println("被拦截的方法参数：" + Arrays.toString(joinPoint.getArgs()));
    }
    
    @AfterReturning(value = "execution(* com..FinanceService.subtractMoney(double))", returning = "retval")
    public void afterReturningPrint(Object retval) {
        System.out.println("Logger afterReturningPrint run ......");
        System.out.println("返回的数据：" + retval);
    }
    
    @AfterThrowing(value = "defaultPointcut()", throwing = "e")
    public void afterThrowingPrint(JoinPoint joinPoint, Exception e) {
        System.out.println("Logger afterThrowingPrint run ......");
        System.out.println("抛出的异常：" + e.getMessage());
    }
    
    @Around("defaultPointcut()")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }
    
    @Pointcut("execution(public * com.linkedbear.spring.aop.c_joinpoint.service.FinanceService.subtractMoney(..))")
    public void defaultPointcut() {
    
    }
}
