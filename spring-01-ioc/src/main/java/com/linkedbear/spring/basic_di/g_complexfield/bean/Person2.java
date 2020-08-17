package com.linkedbear.spring.basic_di.g_complexfield.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class Person2 {
    
    @Value("#{new String[] {'张三', '张三丰'}}")
    private String[] names;
    
    @Value("#{{'333333', '3333', '33'}}")
    private List<String> tels;
    
    @Value("#{{@miaomiao, new com.linkedbear.spring.basic_di.g_complexfield.bean.Cat()}}")
    private Set<Cat> cats;
    
    @Value("#{{'喵喵': @miaomiao.name, '猫猫': new com.linkedbear.spring.basic_di.g_complexfield.bean.Cat().name}}")
    private Map<String, Object> events;
    
    @Value("#{{'123': '牵着手', '456': '抬起头', '789': '我们私奔到月球'}}")
    private Properties props;
    
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
