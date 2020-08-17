package com.linkedbear.spring.basic_di.b_constructor.bean;

public class Cat {
    
    private String name;
    private Person father;
    
    public Cat(String name, Person father) {
        this.name = name;
        this.father = father;
    }
    
    public String getName() {
        return name;
    }
    
    public Person getFather() {
        return father;
    }
    
    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", father=" + father + '}';
    }
}
