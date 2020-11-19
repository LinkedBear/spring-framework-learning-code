package com.linkedbear.spring.transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.linkedbear.spring.transaction")
public class TransactionAspectConfiguration {
    
}
