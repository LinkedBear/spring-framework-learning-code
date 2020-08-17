package com.linkedbear.spring.basic_di.i_lazyinject;

import com.linkedbear.spring.basic_di.i_lazyinject.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyInjectAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.basic_di.i_lazyinject.bean");
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);
    }
}
