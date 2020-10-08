package com.linkedbear.spring.programmatic.a_quickstart;

import com.linkedbear.spring.programmatic.a_quickstart.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProgrammaticQuickstartApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        
        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "zhangsan").getBeanDefinition();
        ctx.registerBeanDefinition("person", personDefinition);
        ctx.refresh();
        
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
