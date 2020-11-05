package com.linkedbear.architecture.i_template.service;

import com.linkedbear.architecture.g_logutils.utils.LogUtils;

public abstract class AbstractDemoService implements DemoService {
    
    @Override
    public int add(String userId, int points) {
        LogUtils.printLog("DemoService", "add", userId, points);
        return doAdd(userId, points);
    }
    
    protected abstract int doAdd(String userId, int points);
    
    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoService", "subtract", userId, points);
        return 0;
    }
    
    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoService", "multiply", userId, points);
        return 0;
    }
    
    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoService", "divide", userId, points);
        return 0;
    }
}
