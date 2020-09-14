package com.linkedbear.spring.annotation.i_propertyyml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcYmlProperty {
    
    @Value("${yml.jdbc.url}")
    private String url;
    
    @Value("${yml.jdbc.driver-class-name}")
    private String driverClassName;
    
    @Value("${yml.jdbc.username}")
    private String username;
    
    @Value("${yml.jdbc.password}")
    private String password;
    
    @Override
    public String toString() {
        return "JdbcYmlProperty{"
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
