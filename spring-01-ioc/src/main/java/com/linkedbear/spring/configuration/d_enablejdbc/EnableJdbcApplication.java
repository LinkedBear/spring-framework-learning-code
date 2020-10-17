package com.linkedbear.spring.configuration.d_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.linkedbear.spring.configuration.d_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableJdbc
public class EnableJdbcApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
    }
}
