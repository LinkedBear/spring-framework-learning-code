package com.linkedbear.spring.postprocessor.f_destruction.config;

import com.linkedbear.spring.postprocessor.f_destruction.bean.Pen;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DestructionPenPostProcessor implements DestructionAwareBeanPostProcessor {
    
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean instanceof Pen) {
            System.out.println("DestructionPenPostProcessor postProcessBeforeDestruction run ......");
            Pen pen = (Pen) bean;
            pen.setInk(0);
        }
    }
}
