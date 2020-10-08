package com.linkedbear.spring.postprocessor.a_quickstart.config;

import com.linkedbear.spring.postprocessor.a_quickstart.bean.Cat;
import com.linkedbear.spring.postprocessor.a_quickstart.bean.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AnimalBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("拦截到Bean的初始化之前：" + bean);
        if (bean instanceof Cat) {
            return new Dog();
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("拦截到Bean的初始化之后：" + bean);
        return bean;
    }
}
