package com.linkedbear.spring.basic_di.d_autowired;

import com.linkedbear.spring.basic_di.d_autowired.bean.Cat;
import com.linkedbear.spring.basic_di.d_autowired.bean.Dog;
import com.linkedbear.spring.basic_di.d_autowired.config.AutowiredConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AutowiredConfiguration.class);
    
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
        
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);
    }
}
