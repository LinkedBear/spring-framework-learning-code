package com.linkedbear.architecture.d_properties.service.impl;

import com.linkedbear.architecture.d_properties.dao.DemoDao;
import com.linkedbear.architecture.d_properties.factory.BeanFactory;
import com.linkedbear.architecture.d_properties.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    public DemoServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
    }
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
