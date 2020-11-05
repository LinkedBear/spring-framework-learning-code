package com.linkedbear.architecture.i_template.service.impl;

import com.linkedbear.architecture.i_template.dao.DemoDao;
import com.linkedbear.architecture.i_template.factory.BeanFactory;
import com.linkedbear.architecture.i_template.service.AbstractDemoService;
import com.linkedbear.architecture.i_template.service.DemoService;

import java.util.List;

public class DemoServiceImpl extends AbstractDemoService implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    protected int doAdd(String userId, int points) {
        return points;
    }
}
