package com.linkedbear.spring.transaction.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
    
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    
    public static Connection getConnection() {
        if (connectionThreadLocal.get() != null) {
            return connectionThreadLocal.get();
        }
        return openConnection();
    }
    
    public static Connection openConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(JDBC_URL, "root", "123456");
            connectionThreadLocal.set(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    
    public static void remove() {
        connectionThreadLocal.remove();
    }
}
