package com.linkedbear.spring.configuration.b_profile;

import com.linkedbear.spring.configuration.b_profile.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class TavernProfileApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        ctx.getEnvironment().setActiveProfiles("city");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("city");
//        ctx.register(TavernConfiguration.class);
//        ctx.refresh();
//        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
