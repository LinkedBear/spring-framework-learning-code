package com.linkedbear.spring.definition.c_removedefinition;

import com.linkedbear.spring.definition.c_removedefinition.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoveBeanDefinitionApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("definition/remove-definitions.xml");
        Person aqiang = (Person) ctx.getBean("aqiang");
        System.out.println(aqiang);
    }
}
