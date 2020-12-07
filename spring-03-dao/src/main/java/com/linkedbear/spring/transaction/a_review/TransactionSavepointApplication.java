package com.linkedbear.spring.transaction.a_review;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TransactionSavepointApplication {
    
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        Connection connection = null;
        Savepoint savepoint = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
    
            PreparedStatement statement = connection
                    .prepareStatement("insert into tbl_user (name, tel) values ('hahaha', '12345')");
            statement.executeUpdate();
    
            savepoint = connection.setSavepoint();
            
            statement = connection.prepareStatement("insert into tbl_account (user_id, money) values (2, 123)");
            statement.executeUpdate();
    
            int i = 1 / 0;
    
            statement = connection.prepareStatement("delete from tbl_user where id = 1");
            statement.executeUpdate();
    
            connection.commit();
        } catch (Exception e) {
            if (savepoint != null) {
                connection.rollback(savepoint);
                connection.commit();
            } else {
                connection.rollback();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
