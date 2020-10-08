package com.linkedbear.spring.definition.b_registry;

import com.linkedbear.spring.definition.b_registry.bean.Person;
import com.linkedbear.spring.definition.b_registry.config.BeanDefinitionRegistryConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionRegistryApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                BeanDefinitionRegistryConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
