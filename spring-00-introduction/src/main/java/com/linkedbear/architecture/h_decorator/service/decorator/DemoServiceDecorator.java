package com.linkedbear.architecture.h_decorator.service.decorator;

import com.linkedbear.architecture.g_logutils.utils.LogUtils;
import com.linkedbear.architecture.h_decorator.service.DemoService;

import java.util.List;

public class DemoServiceDecorator implements DemoService {
    
    private DemoService target;
    
    public DemoServiceDecorator(DemoService target) {
        this.target = target;
    }
    
    @Override
    public List<String> findAll() {
        return target.findAll();
    }
    
    @Override
    public int add(String userId, int points) {
        LogUtils.printLog("DemoService", "add", userId, points);
        return target.add(userId, points);
    }
    
    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoService", "subtract", userId, points);
        return target.subtract(userId, points);
    }
    
    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoService", "multiply", userId, points);
        return target.multiply(userId, points);
    }
    
    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoService", "divide", userId, points);
        return target.divide(userId, points);
    }
}
