package com.linkedbear.spring.container.b_applicationcontext.config;

import com.linkedbear.spring.container.b_applicationcontext.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfiguration {
    
    @Bean
    public Dog dog() {
        return new Dog();
    }
    
}
