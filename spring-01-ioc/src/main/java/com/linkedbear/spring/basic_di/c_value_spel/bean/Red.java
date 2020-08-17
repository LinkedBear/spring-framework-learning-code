package com.linkedbear.spring.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Red {
    
    @Value("${red.name}")
    private String name;
    
    @Value("${red.order}")
    private Integer order;
    
    @Override
    public String toString() {
        return "Red{" + "name='" + name + '\'' + ", order=" + order + '}';
    }
}
