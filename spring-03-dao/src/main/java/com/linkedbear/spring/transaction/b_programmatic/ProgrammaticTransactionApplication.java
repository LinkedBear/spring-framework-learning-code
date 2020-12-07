package com.linkedbear.spring.transaction.b_programmatic;

import com.linkedbear.spring.transaction.b_programmatic.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgrammaticTransactionApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/programmatic-transaction.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.saveAndQuery();
    }
}
