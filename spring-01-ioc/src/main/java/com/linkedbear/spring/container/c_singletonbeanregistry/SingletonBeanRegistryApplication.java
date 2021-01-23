package com.linkedbear.spring.container.c_singletonbeanregistry;

import com.linkedbear.spring.basic_dl.a_quickstart_byname.bean.Person;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

public class SingletonBeanRegistryApplication {
    
    public static void main(String[] args) throws Exception {
        /*
        DefaultSingletonBeanRegistry singletonBeanRegistry = new DefaultSingletonBeanRegistry();
        Person person = new Person();
        singletonBeanRegistry.registerSingleton("person", person);
        System.out.println(person == singletonBeanRegistry.getSingleton("person"));
        String[] singletonNames = singletonBeanRegistry.getSingletonNames();
        Stream.of(singletonNames).forEach(System.out::println);
        singletonBeanRegistry.destroySingleton("person");
        System.out.println(singletonBeanRegistry.getSingleton("person"));
        System.out.println(singletonBeanRegistry.getSingletonNames().length);
        */
        
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
        DefaultSingletonBeanRegistry singletonBeanRegistry = (DefaultSingletonBeanRegistry) ctx.getBeanFactory();
        Person person = (Person) singletonBeanRegistry.getSingleton("person");
        System.out.println(person);
        singletonBeanRegistry.destroySingleton("person");
        System.out.println(singletonBeanRegistry.getSingleton("person"));
        System.out.println(ctx.getBean("person"));
    }
}
