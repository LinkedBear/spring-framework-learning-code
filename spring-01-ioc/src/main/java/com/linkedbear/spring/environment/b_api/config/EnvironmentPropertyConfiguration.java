package com.linkedbear.spring.environment.b_api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.linkedbear.spring.environment.b_api.bean")
@PropertySource("propertysource/jdbc.properties")
public class EnvironmentPropertyConfiguration {
    
}
