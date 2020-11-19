package com.linkedbear.spring.aop.h_imitate;

import com.linkedbear.spring.aop.h_imitate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImitateAopApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.linkedbear.spring.aop.h_imitate");
        UserService userService = ctx.getBean(UserService.class);
        userService.get("abc");
    }
}
