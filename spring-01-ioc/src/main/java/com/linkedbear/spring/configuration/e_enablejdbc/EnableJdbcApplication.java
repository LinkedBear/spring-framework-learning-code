package com.linkedbear.spring.configuration.e_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.linkedbear.spring.configuration.e_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableJdbc
@PropertySource("enablejdbc/jdbc.properties")
public class EnableJdbcApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getDriverClassName());
    }
}
