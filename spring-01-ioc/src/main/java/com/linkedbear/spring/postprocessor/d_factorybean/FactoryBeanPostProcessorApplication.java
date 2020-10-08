package com.linkedbear.spring.postprocessor.d_factorybean;

import com.linkedbear.spring.postprocessor.d_factorybean.bean.Egg;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanPostProcessorApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.d_factorybean");
        Egg egg = ctx.getBean(Egg.class);
        System.out.println(egg);
    }
}
