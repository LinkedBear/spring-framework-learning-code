package com.linkedbear.spring.basic_di.d_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dog {
    
    @Value("dogdog")
    private String name;
    
    @Autowired
    @Qualifier("administrator")
    private Person person;
    
    @Autowired
    private List<Person> persons;
    
    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", person=" + person + ", persons=" + persons + '}';
    }
}
