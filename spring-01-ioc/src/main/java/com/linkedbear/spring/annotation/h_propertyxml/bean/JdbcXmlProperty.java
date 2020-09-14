package com.linkedbear.spring.annotation.h_propertyxml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcXmlProperty {
    
    @Value("${xml.jdbc.url}")
    private String url;
    
    @Value("${xml.jdbc.driver-class-name}")
    private String driverClassName;
    
    @Value("${xml.jdbc.username}")
    private String username;
    
    @Value("${xml.jdbc.password}")
    private String password;
    
    @Override
    public String toString() {
        return "JdbcXmlProperty{"
                + "url='"
                + url
                + '\''
                + ", driverClassName='"
                + driverClassName
                + '\''
                + ", username='"
                + username
                + '\''
                + ", password='"
                + password
                + '\''
                + '}';
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDriverClassName() {
        return driverClassName;
    }
    
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
