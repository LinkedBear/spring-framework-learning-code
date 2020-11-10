package com.linkedbear.spring.aop.b_aspectj;

import com.linkedbear.spring.aop.b_aspectj.config.AspectJAOPConfiguration;
import com.linkedbear.spring.aop.b_aspectj.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAspectJApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                AspectJAOPConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
    }
}
