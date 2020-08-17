package com.linkedbear.spring.basic_di.g_complexfield;

import com.linkedbear.spring.basic_di.g_complexfield.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexFieldXmlApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_di/complexfield/inject-complexfield.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
