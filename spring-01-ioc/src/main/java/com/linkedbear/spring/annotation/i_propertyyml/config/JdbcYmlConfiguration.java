package com.linkedbear.spring.annotation.i_propertyyml.config;

import com.linkedbear.spring.annotation.i_propertyyml.factory.YmlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.linkedbear.spring.annotation.i_propertyyml.bean")
@PropertySource(value = "classpath:propertysource/jdbc.yml", factory = YmlPropertySourceFactory.class)
public class JdbcYmlConfiguration {
    
}
