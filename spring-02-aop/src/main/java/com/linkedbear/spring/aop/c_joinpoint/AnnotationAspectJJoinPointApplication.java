package com.linkedbear.spring.aop.c_joinpoint;

import com.linkedbear.spring.aop.c_joinpoint.config.AspectJJoinPointAOPConfiguration;
import com.linkedbear.spring.aop.c_joinpoint.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAspectJJoinPointApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                AspectJJoinPointAOPConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(543.21);
    }
}
