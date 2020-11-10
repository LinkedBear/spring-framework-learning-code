package com.linkedbear.spring.aop.c_joinpoint.service;

import java.util.List;

public interface OrderService {
    
    void createOrder();
    
    void deleteOrderById(String id);
    
    String getOrderById(String id);
    
    List<String> findAll();
}
