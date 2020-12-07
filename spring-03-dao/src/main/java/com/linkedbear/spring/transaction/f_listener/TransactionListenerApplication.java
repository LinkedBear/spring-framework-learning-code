package com.linkedbear.spring.transaction.f_listener;

import com.linkedbear.spring.transaction.f_listener.config.TransactionListenerConfiguration;
import com.linkedbear.spring.transaction.f_listener.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionListenerApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                TransactionListenerConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.saveUser();
    }
}
