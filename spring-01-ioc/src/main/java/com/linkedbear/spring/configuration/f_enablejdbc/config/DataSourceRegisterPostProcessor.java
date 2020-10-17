package com.linkedbear.spring.configuration.f_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.sql.Driver;
import java.util.List;

public class DataSourceRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
    
    private Environment environment;
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(DruidDataSource.class)
                .addPropertyValue("url", environment.getProperty("jdbc.url"))
                .addPropertyValue("username", environment.getProperty("jdbc.username"))
                .addPropertyValue("password", environment.getProperty("jdbc.password"));
        // 根据当前classpath下的数据库连接驱动添加driverClassName
        List<String> driverClassNames = SpringFactoriesLoader.loadFactoryNames(Driver.class, this.getClass().getClassLoader());
        String driverClassName = null;
        for (String temp : driverClassNames) {
            try {
                Class.forName(temp);
                driverClassName = temp;
                break;
            } catch (ClassNotFoundException ignored) {
                // 加载失败，classpath下无当前驱动，继续下一个
            }
        }
        // 存在驱动，注册DataSource
        if (driverClassName != null) {
            builder.addPropertyValue("driverClassName", driverClassName);
            registry.registerBeanDefinition("dataSource", builder.getBeanDefinition());
        }
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    
    }
    
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
