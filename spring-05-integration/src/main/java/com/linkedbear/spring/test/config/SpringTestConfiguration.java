package com.linkedbear.spring.test.config;

import com.linkedbear.spring.test.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfiguration {
    
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
