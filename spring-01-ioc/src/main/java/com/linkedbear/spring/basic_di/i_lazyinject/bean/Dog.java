package com.linkedbear.spring.basic_di.i_lazyinject.bean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    
    @Autowired
    private ObjectProvider<Person> person;
    
    @Override
    public String toString() {
        return "Dog{" + "person=" + person.getIfAvailable(Person::new) + '}';
    }
}
