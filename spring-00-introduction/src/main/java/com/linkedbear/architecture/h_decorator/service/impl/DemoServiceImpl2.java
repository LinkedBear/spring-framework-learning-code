package com.linkedbear.architecture.h_decorator.service.impl;

import com.linkedbear.architecture.h_decorator.dao.DemoDao;
import com.linkedbear.architecture.h_decorator.factory.BeanFactory;
import com.linkedbear.architecture.h_decorator.service.DemoService;

import java.util.List;

public class DemoServiceImpl2 implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        System.out.println("DemoServiceImpl2 add ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int subtract(String userId, int points) {
        System.out.println("DemoServiceImpl2 subtract ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int multiply(String userId, int points) {
        System.out.println("DemoServiceImpl2 multiply ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int divide(String userId, int points) {
        System.out.println("DemoServiceImpl2 divide ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
}
