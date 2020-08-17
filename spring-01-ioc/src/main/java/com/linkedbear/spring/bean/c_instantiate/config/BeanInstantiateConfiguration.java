package com.linkedbear.spring.bean.c_instantiate.config;

import com.linkedbear.spring.bean.c_instantiate.bean.BallFactoryBean;
import com.linkedbear.spring.bean.c_instantiate.bean.Car;
import com.linkedbear.spring.bean.c_instantiate.bean.CarInstanceFactory;
import com.linkedbear.spring.bean.c_instantiate.bean.CarStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.linkedbear.spring.bean.c_instantiate.bean")
public class BeanInstantiateConfiguration {
    
    @Bean
    public BallFactoryBean ballFactoryBean() {
        return new BallFactoryBean();
    }
    
    @Bean
    public Car car2() {
        return CarStaticFactory.getCar();
    }
    
    @Bean
    public CarInstanceFactory carInstanceFactory() {
        return new CarInstanceFactory();
    }
    
    @Bean
    public Car car3(CarInstanceFactory carInstanceFactory) {
        return carInstanceFactory.getCar();
    }
    
}
