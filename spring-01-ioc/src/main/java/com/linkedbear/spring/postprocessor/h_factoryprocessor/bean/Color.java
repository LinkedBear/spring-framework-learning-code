package com.linkedbear.spring.postprocessor.h_factoryprocessor.bean;

public abstract class Color {
    
    public Color() {
        System.out.println("Color constructor run ......");
    }
    
    protected String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
