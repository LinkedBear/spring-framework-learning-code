package com.linkedbear.spring.configuration.e_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.linkedbear.spring.configuration.e_enablejdbc.annotation.ConditionalOnClassName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClassName("com.mysql.jdbc.Driver")
public class MySQLJdbcConfiguration extends AbstractJdbcConfiguration {
    
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }
}
