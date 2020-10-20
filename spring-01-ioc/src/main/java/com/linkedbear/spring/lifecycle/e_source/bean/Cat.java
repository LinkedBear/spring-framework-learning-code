package com.linkedbear.spring.lifecycle.e_source.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    
    @Value("miaomiao")
    private String name;
    
    @Autowired
    private Person master;
    
    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", master=" + master + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Person getMaster() {
        return master;
    }
    
    public void setMaster(Person master) {
        this.master = master;
    }
}
