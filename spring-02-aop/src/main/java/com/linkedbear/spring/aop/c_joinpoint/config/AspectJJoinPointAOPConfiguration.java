package com.linkedbear.spring.aop.c_joinpoint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.linkedbear.spring.aop.c_joinpoint")
@EnableAspectJAutoProxy
public class AspectJJoinPointAOPConfiguration {
    
}
