package com.linkedbear.architecture.i_template.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    
    private static Map<String, Object> beanMap = new HashMap<>();
    
    private static Properties properties;
    
    // 使用静态代码块初始化properties，加载factory_i.properties文件
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory_i.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }
    
    public static Object getBean(String beanName) {
        // 双检锁保证beanMap中确实没有beanName对应的对象
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    // 过了双检锁，证明确实没有，可以执行反射创建
                    try {
                        Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
                        Object bean = beanClazz.newInstance();
                        // 反射创建后放入缓存再返回
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }
    
}