package com.linkedbear.architecture.g_logutils.service.impl;

import com.linkedbear.architecture.g_logutils.dao.DemoDao;
import com.linkedbear.architecture.g_logutils.factory.BeanFactory;
import com.linkedbear.architecture.g_logutils.service.DemoService;
import com.linkedbear.architecture.g_logutils.utils.LogUtils;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl", "add", userId, points);
        return points;
    }
    
    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl", "subtract", userId, points);
        return points;
    }
    
    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl", "multiply", userId, points);
        return points;
    }
    
    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl", "divide", userId, points);
        return points;
    }
}
