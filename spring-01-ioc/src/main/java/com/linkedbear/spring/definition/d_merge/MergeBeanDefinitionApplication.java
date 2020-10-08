package com.linkedbear.spring.definition.d_merge;

import com.linkedbear.spring.definition.d_merge.bean.Cat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MergeBeanDefinitionApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("definition/definition-merge.xml");
        Cat cat = (Cat) ctx.getBean("cat");
        System.out.println(cat);
        
        BeanDefinition catDefinition = ctx.getBeanFactory().getBeanDefinition("cat");
        System.out.println(catDefinition);
        
        BeanDefinition mergedCatDefinition = ctx.getBeanFactory().getMergedBeanDefinition("cat");
        System.out.println(mergedCatDefinition);
    }
}
