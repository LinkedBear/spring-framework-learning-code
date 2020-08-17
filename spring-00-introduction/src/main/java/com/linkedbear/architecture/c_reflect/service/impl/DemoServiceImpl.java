package com.linkedbear.architecture.c_reflect.service.impl;

import com.linkedbear.architecture.c_reflect.dao.DemoDao;
import com.linkedbear.architecture.c_reflect.factory.BeanFactory;
import com.linkedbear.architecture.c_reflect.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = BeanFactory.getDemoDao();
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
