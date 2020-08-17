package com.linkedbear.spring.basic_di.d_autowired.config;

import com.linkedbear.spring.basic_di.d_autowired.bean.Cat;
import com.linkedbear.spring.basic_di.d_autowired.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.linkedbear.spring.basic_di.d_autowired.bean")
public class AutowiredConfiguration {

    @Bean
    @Autowired
    public Cat cat(Person person) {
        Cat cat = new Cat();
        cat.setName("mimi");
        cat.setPerson(person);
        return cat;
    }
    
    @Bean
    @Primary
    public Person master() {
        Person master = new Person();
        master.setName("master");
        return master;
    }

}
