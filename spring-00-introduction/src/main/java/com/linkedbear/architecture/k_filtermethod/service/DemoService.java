package com.linkedbear.architecture.k_filtermethod.service;

import java.util.List;

public interface DemoService {
    List<String> findAll();
    
    int add(String userId, int points);
    int subtract(String userId, int points);
    int multiply(String userId, int points);
    int divide(String userId, int points);
}
