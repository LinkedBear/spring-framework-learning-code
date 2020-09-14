package com.linkedbear.spring.annotation.g_propertysource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.linkedbear.spring.annotation.g_propertysource.bean")
@PropertySource("classpath:propertysource/jdbc.properties")
public class JdbcPropertiesConfiguration {
    
}
