package com.linkedbear.spring.aop.a_xmlaspect.service;

import java.util.List;

public interface OrderService {
    
    void createOrder();
    
    void deleteOrderById(String id);
    
    String getOrderById(String id);
    
    List<String> findAll();
}
