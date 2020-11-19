package com.linkedbear.spring.aop.g_weaving;

import com.linkedbear.spring.aop.g_weaving.config.LoadTimeWeavingConfiguration;
import com.linkedbear.spring.aop.g_weaving.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoadTimeWeavingApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LoadTimeWeavingConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.get("aaa");
    }
}
