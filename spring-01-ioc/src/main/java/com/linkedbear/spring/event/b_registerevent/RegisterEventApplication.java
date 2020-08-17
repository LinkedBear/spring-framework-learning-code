package com.linkedbear.spring.event.b_registerevent;

import com.linkedbear.spring.event.b_registerevent.service.RegisterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterEventApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.event.b_registerevent");
        RegisterService registerService = ctx.getBean(RegisterService.class);
        registerService.register("张大三");
    }
}
