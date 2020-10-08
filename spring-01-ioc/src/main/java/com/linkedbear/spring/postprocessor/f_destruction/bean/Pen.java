package com.linkedbear.spring.postprocessor.f_destruction.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class Pen implements DisposableBean {
    
    private Integer ink = 100;
    
    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy - 钢笔中的墨水都放干净了。。。");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("Pen DisposableBean 写完字了。。。");
    }
    
    public Integer getInk() {
        return ink;
    }
    
    public void setInk(Integer ink) {
        this.ink = ink;
    }
}
