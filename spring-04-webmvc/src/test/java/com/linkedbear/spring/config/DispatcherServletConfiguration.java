package com.linkedbear.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.linkedbear.spring",
               includeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
               useDefaultFilters = false)
public class DispatcherServletConfiguration implements WebMvcConfigurer {
    
}
