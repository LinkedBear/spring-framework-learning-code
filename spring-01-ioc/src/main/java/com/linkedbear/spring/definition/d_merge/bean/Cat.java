package com.linkedbear.spring.definition.d_merge.bean;

public class Cat extends Animal {
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", person='" + getPerson() + '\'' + "}";
    }
}
