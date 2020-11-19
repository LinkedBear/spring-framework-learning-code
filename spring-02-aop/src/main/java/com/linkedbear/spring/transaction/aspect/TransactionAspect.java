package com.linkedbear.spring.transaction.aspect;

import com.linkedbear.spring.transaction.util.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
@Aspect
public class TransactionAspect {
    
    @Around("@annotation(com.linkedbear.spring.transaction.aspect.Transactional)")
    public Object doWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        try {
            Object retval = joinPoint.proceed();
            connection.commit();
            return retval;
        } catch (Throwable e) {
            connection.rollback();
            throw e;
        } finally {
            JdbcUtils.remove();
        }
    }
}
