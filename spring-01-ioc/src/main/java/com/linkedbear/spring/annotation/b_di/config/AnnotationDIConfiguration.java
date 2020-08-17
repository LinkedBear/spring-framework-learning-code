package com.linkedbear.spring.annotation.b_di.config;

import com.linkedbear.spring.annotation.b_di.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationDIConfiguration {
    
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("person");
        person.setAge(123);
        return person;
    }
    
}
