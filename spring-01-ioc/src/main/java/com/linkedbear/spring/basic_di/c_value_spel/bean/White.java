package com.linkedbear.spring.basic_di.c_value_spel.bean;

public class White {
    
    private String name;
    
    private Integer order;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    @Override
    public String toString() {
        return "White{" + "name='" + name + '\'' + ", order=" + order + '}';
    }
}
