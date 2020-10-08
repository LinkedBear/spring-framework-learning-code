package com.linkedbear.spring.programmatic.b_di.bean;

import com.linkedbear.spring.programmatic.a_quickstart.bean.Person;

public abstract class Animal {
    
    public Animal() {
        System.out.println("Animal constructor run ......");
    }
    
    protected String name;
    
    protected Person person;
    
    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", person=" + person + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
}
