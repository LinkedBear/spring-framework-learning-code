package com.linkedbear.spring.basic_di.h_aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AwaredTestBean implements ApplicationContextAware, BeanNameAware {
    
    private String beanName;
    private ApplicationContext ctx;
    
    public String getName() {
        return beanName;
    }
    
    public void printBeanNames() {
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}