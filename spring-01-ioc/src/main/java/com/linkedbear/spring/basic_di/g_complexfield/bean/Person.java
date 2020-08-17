package com.linkedbear.spring.basic_di.g_complexfield.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

    private String[] names;
    private List<String> tels;
    private Set<Cat> cats;
    private Map<String, Object> events;
    private Properties props;
    
    public void setNames(String[] names) {
        this.names = names;
    }
    
    public void setTels(List<String> tels) {
        this.tels = tels;
    }
    
    public void setCats(Set<Cat> cats) {
        this.cats = cats;
    }
    
    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }
    
    public void setProps(Properties props) {
        this.props = props;
    }
    
    @Override
    public String toString() {
        return "Person{\n"
                + " names="
                + Arrays.toString(names)
                + ",\n tels="
                + tels
                + ",\n cats="
                + cats
                + ",\n events="
                + events
                + ",\n props="
                + props
                + "\n}";
    }
}
