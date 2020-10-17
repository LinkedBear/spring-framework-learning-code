package com.linkedbear.spring.configuration.z_spi;

import com.linkedbear.spring.configuration.z_spi.bean.DemoDao;

import java.util.ServiceLoader;

public class JdkSpiApplication {
    
    public static void main(String[] args) throws Exception {
        ServiceLoader<DemoDao> serviceLoader = ServiceLoader.load(DemoDao.class);
        serviceLoader.iterator().forEachRemaining(dao -> {
            System.out.println(dao);
        });
    }
}
