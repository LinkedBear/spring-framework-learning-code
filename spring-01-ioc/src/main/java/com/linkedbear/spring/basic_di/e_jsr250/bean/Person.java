package com.linkedbear.spring.basic_di.e_jsr250.bean;

public class Person {
    
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}
