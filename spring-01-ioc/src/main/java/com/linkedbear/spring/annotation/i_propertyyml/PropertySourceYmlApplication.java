package com.linkedbear.spring.annotation.i_propertyyml;

import com.linkedbear.spring.annotation.i_propertyyml.bean.JdbcYmlProperty;
import com.linkedbear.spring.annotation.i_propertyyml.config.JdbcYmlConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceYmlApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcYmlConfiguration.class);
        System.out.println(ctx.getBean(JdbcYmlProperty.class).toString());
    }
}
