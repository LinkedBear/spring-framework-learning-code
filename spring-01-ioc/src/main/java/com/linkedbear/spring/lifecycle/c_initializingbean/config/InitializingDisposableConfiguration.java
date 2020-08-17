package com.linkedbear.spring.lifecycle.c_initializingbean.config;

import com.linkedbear.spring.lifecycle.c_initializingbean.bean.Pen3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializingDisposableConfiguration {
    
    @Bean(initMethod = "open", destroyMethod = "close")
    public Pen3 pen() {
        return new Pen3();
    }
    
}
