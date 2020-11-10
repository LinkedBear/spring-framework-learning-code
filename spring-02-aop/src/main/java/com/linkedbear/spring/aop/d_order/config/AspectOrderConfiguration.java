package com.linkedbear.spring.aop.d_order.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.linkedbear.spring.aop.d_order")
@EnableAspectJAutoProxy
public class AspectOrderConfiguration {
    
}
