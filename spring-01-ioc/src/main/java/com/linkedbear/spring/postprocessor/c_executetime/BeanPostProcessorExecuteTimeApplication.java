package com.linkedbear.spring.postprocessor.c_executetime;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorExecuteTimeApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "postprocessor/processor-executetime.xml");
        ctx.close();
    }
}
