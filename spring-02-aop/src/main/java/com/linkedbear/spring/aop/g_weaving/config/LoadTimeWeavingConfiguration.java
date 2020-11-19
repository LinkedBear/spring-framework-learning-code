package com.linkedbear.spring.aop.g_weaving.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@ComponentScan("com.linkedbear.spring.aop.g_weaving")
//@EnableAspectJAutoProxys
@EnableLoadTimeWeaving
public class LoadTimeWeavingConfiguration {
    
}
