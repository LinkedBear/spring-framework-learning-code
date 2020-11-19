package com.linkedbear.spring.aop.f_introduction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.linkedbear.spring.aop.f_introduction")
public class IntroductionConfiguration {
    
}
