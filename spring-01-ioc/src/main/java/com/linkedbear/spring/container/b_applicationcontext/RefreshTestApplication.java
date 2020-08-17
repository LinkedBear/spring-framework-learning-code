package com.linkedbear.spring.container.b_applicationcontext;

import com.linkedbear.spring.container.b_applicationcontext.config.CatConfiguration;
import com.linkedbear.spring.container.b_applicationcontext.config.DogConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class RefreshTestApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CatConfiguration.class);
        ctx.refresh();
    
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println();
        
        ctx.register(DogConfiguration.class);
        // 此处会抛出重复刷新异常
        ctx.refresh();
    
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
