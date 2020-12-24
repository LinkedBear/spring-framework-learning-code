package com.linkedbear.spring.b_anno.config;

import com.linkedbear.spring.a_xml.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
