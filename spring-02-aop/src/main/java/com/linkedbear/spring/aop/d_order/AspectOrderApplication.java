package com.linkedbear.spring.aop.d_order;

import com.linkedbear.spring.aop.d_order.config.AspectOrderConfiguration;
import com.linkedbear.spring.aop.d_order.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectOrderApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectOrderConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.saveUser("abc");
    }
}
