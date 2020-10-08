package com.linkedbear.spring.postprocessor.b_getproperty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorGetPropertyApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.b_getproperty");
        ctx.close();
    }
}
