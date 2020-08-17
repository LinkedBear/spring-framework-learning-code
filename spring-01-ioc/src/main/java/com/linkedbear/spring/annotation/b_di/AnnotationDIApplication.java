package com.linkedbear.spring.annotation.b_di;

import com.linkedbear.spring.annotation.b_di.bean.Person;
import com.linkedbear.spring.annotation.b_di.config.AnnotationDIConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDIApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationDIConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
