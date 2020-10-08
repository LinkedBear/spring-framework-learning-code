package com.linkedbear.spring.postprocessor.g_mergedefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MergeDefinitionPostProcessorApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.g_mergedefinition");
        ctx.close();
    }
}
