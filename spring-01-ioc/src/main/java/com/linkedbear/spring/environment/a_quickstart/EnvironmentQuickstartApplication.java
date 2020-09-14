package com.linkedbear.spring.environment.a_quickstart;

import com.linkedbear.spring.environment.a_quickstart.bean.EnvironmentHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EnvironmentQuickstartApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.environment.a_quickstart.bean");
        EnvironmentHolder environmentHolder = ctx.getBean(EnvironmentHolder.class);
        environmentHolder.printEnvironment();
    }
}
