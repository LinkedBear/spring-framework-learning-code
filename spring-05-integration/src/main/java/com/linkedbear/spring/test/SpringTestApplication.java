package com.linkedbear.spring.test;

import com.linkedbear.spring.test.bean.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test/spring-test.xml");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
