package com.linkedbear.architecture.l_proxyfactory.factory;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    
    private static Map<String, Object> beanMap = new HashMap<>();
    
    private static Properties properties;
    
    // 使用静态代码块初始化properties，加载factory_l.properties文件
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory_l.properties"));
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
                        
                        // 检查properties中是否有定义代理增强
                        String proxyAdvisorClassName = properties.getProperty(beanName + ".proxy.class");
                        if (proxyAdvisorClassName != null && proxyAdvisorClassName.trim().length() > 0) {
                            // 有定义代理增强，需要反射创建InvocationHandler的实现类
                            Class<?> proxyAdvisorClass = Class.forName(proxyAdvisorClassName);
                            
                            // 从properties中找出当前bean需要增强的方法列表
                            String[] methods = properties.getProperty(beanName + ".proxy.methods").split(",");
                            
                            // 要求InvocationHandler的实现类必须声明两参数构造方法
                            // 其中第一个参数是被代理的目标对象，第二个参数是要增强的方法列表
                            InvocationHandler proxyHandler = (InvocationHandler) proxyAdvisorClass.getConstructors()[0]
                                    .newInstance(bean, methods);
                            // 动态代理创建对象
                            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                                    bean.getClass().getInterfaces(), proxyHandler);
                            bean = proxy;
                            // 经过该步骤后，放入beanMap的对象就是已经被增强过的代理对象
                        }
                        
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }
    
}