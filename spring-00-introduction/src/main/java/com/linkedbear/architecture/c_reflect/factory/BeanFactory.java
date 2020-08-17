package com.linkedbear.architecture.c_reflect.factory;

import com.linkedbear.architecture.c_reflect.dao.DemoDao;
import com.linkedbear.architecture.c_reflect.service.DemoService;

public class BeanFactory {
    
    public static DemoService getDemoService() {
        try {
            return (DemoService) Class.forName("com.linkedbear.architecture.c_reflect.service.impl.DemoServiceImpl")
                    .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoService instantiation error, cause: " + e.getMessage());
        }
    }
    
    public static DemoDao getDemoDao() {
        try {
            return (DemoDao) Class.forName("com.linkedbear.architecture.c_reflect.dao.impl.DemoDaoImpl").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoDao instantiation error, cause: " + e.getMessage());
        }
    }
    
}
