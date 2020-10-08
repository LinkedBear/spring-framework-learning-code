package com.linkedbear.spring.postprocessor.b_getproperty.config;

import com.linkedbear.spring.postprocessor.b_getproperty.bean.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CatBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Cat) {
            Cat cat = (Cat) bean;
            System.out.println("初始化之前，cat的name为：" + cat.getName());
            cat.setName("zhangsan");
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Cat) {
            Cat cat = (Cat) bean;
            System.out.println("初始化之后，cat的name为：" + cat.getName());
        }
        return bean;
    }
}
