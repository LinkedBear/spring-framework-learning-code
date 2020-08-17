package com.linkedbear.spring.lifecycle.a_initmethod;

import com.linkedbear.spring.lifecycle.a_initmethod.config.InitMethodConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMethodAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InitMethodConfiguration.class);
        System.out.println("IOC容器初始化完成。。。");
        Thread.sleep(3000);
        ctx.close();
    }
}
