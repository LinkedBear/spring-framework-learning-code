package com.linkedbear.spring.transaction.e_spread;

import com.linkedbear.spring.transaction.e_spread.config.TransactionSpreadConfiguration;
import com.linkedbear.spring.transaction.e_spread.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionSpreadSourceApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionSpreadConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register();
    }
}
