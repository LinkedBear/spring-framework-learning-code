package com.linkedbear.spring.definition.b_registry.config;

import com.linkedbear.spring.definition.b_registry.register.PersonRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersonRegister.class)
public class BeanDefinitionRegistryConfiguration {
    
}
