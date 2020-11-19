package com.linkedbear.spring.aop.f_introduction;

import com.linkedbear.spring.aop.f_introduction.config.IntroductionConfiguration;
import com.linkedbear.spring.aop.f_introduction.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IntroductionApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(IntroductionConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
        System.out.println("------------------------------");
        financeService.transfer(1L, 2L, -1);
    }
}
