package com.linkedbear.architecture.e_cachedfactory.service.impl;

import com.linkedbear.architecture.e_cachedfactory.dao.DemoDao;
import com.linkedbear.architecture.e_cachedfactory.factory.BeanFactory;
import com.linkedbear.architecture.e_cachedfactory.service.DemoService;

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
