package com.linkedbear.spring.configuration.z_spi;

import com.linkedbear.spring.configuration.z_spi.bean.DemoDao;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class SpringSpiApplication {
    
    public static void main(String[] args) throws Exception {
        List<DemoDao> demoDaos = SpringFactoriesLoader
                .loadFactories(DemoDao.class, SpringSpiApplication.class.getClassLoader());
        demoDaos.forEach(dao -> {
            System.out.println(dao);
        });
    
        System.out.println("------------------------------------------------");
    
        List<String> daoClassNames = SpringFactoriesLoader
                .loadFactoryNames(DemoDao.class, SpringSpiApplication.class.getClassLoader());
        daoClassNames.forEach(className -> {
            System.out.println(className);
        });
    }
}
