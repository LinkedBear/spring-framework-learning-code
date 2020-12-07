package com.linkedbear.spring.transaction.a_review;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionApplication {
    
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
    
            PreparedStatement statement = connection
                    .prepareStatement("insert into tbl_user (name, tel) values ('hahaha', '12345')");
            statement.executeUpdate();
            
            int i = 1 / 0;
    
            statement = connection.prepareStatement("delete from tbl_user where id = 1");
            statement.executeUpdate();
    
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
