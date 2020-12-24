package com.linkedbear.spring.withdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 简单写法，开发中不使用
@Configuration
@ComponentScan(value = "com.linkedbear.spring.withdao",
               includeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
               useDefaultFilters = false)
public class WebMvcConfiguration {
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
