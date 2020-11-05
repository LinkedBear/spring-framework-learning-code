package com.linkedbear.architecture.f_pointslog.service.impl;

import com.linkedbear.architecture.f_pointslog.dao.DemoDao;
import com.linkedbear.architecture.f_pointslog.factory.BeanFactory;
import com.linkedbear.architecture.f_pointslog.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        System.out.println("DemoServiceImpl add ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int subtract(String userId, int points) {
        System.out.println("DemoServiceImpl subtract ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int multiply(String userId, int points) {
        System.out.println("DemoServiceImpl multiply ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
    
    @Override
    public int divide(String userId, int points) {
        System.out.println("DemoServiceImpl divide ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
}
