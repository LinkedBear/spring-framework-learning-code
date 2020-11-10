package com.linkedbear.spring.environment.b_api;

import com.linkedbear.spring.environment.b_api.bean.EnvironmentHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EnvironmentApiApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.linkedbear.spring.environment.b_api");
        EnvironmentHolder environmentHolder = ctx.getBean(EnvironmentHolder.class);
        environmentHolder.printEnvironment();
    }
}
