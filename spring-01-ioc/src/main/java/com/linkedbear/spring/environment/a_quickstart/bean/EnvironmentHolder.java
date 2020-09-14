package com.linkedbear.spring.environment.a_quickstart.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentHolder {
    
    @Autowired
    Environment environment;
    
    public void printEnvironment() {
        System.out.println(environment);
    }
}
