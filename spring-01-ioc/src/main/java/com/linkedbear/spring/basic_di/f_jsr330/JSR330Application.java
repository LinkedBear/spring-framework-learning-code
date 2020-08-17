package com.linkedbear.spring.basic_di.f_jsr330;

import com.linkedbear.spring.basic_di.f_jsr330.bean.Cat;
import com.linkedbear.spring.basic_di.f_jsr330.config.JSR330Configration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JSR330Application {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JSR330Configration.class);
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
