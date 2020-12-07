package com.linkedbear.spring.transaction.e_spread;

import com.linkedbear.spring.transaction.e_spread.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionSpreadApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/transaction-spread.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.register();
    }
}
