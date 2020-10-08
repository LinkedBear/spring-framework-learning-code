package com.linkedbear.spring.postprocessor.g_mergedefinition.config;

import com.linkedbear.spring.postprocessor.g_mergedefinition.bean.Cat;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MergeDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if (Cat.class.equals(beanType)) {
            System.out.println("MergeDefinitionPostProcessor postProcessMergedBeanDefinition run......");
            System.out.println(beanDefinition);
        }
    }
}
