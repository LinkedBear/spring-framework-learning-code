package com.linkedbear.spring.event.c_hierarchical.component;

import org.springframework.context.ApplicationListener;

public class HierarchicalEventListener implements ApplicationListener<HierarchicalEvent> {
    
    @Override
    public void onApplicationEvent(HierarchicalEvent event) {
        System.out.println("监听到HierarchicalEvent：" + event.toString());
    }
}
