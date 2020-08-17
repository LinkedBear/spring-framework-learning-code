package com.linkedbear.spring.annotation.d_importxml;

import com.linkedbear.spring.annotation.d_importxml.config.ImportXmlAnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

public class ImportXmlAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/import-anno.xml");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    
        System.out.println("----------------------");
        
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ImportXmlAnnotationConfiguration.class);
        Stream.of(ctx2.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
