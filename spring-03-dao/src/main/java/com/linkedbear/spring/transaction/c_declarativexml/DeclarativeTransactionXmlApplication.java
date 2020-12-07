package com.linkedbear.spring.transaction.c_declarativexml;

import com.linkedbear.spring.transaction.c_declarativexml.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclarativeTransactionXmlApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/declarative-transaction.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.saveAndQuery();
    }
}
