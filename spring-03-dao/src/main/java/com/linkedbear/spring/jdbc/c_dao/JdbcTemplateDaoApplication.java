package com.linkedbear.spring.jdbc.c_dao;

import com.linkedbear.spring.jdbc.c_dao.config.JdbcConfiguration;
import com.linkedbear.spring.jdbc.c_dao.dao.UserDao;
import com.linkedbear.spring.jdbc.c_dao.dao.impl.UserDaoImpl;
import com.linkedbear.spring.jdbc.c_dao.dao.impl.UserDaoImpl3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcTemplateDaoApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        UserDao userDao = ctx.getBean(UserDaoImpl.class);
        userDao.findAll().forEach(System.out::println);
        
        UserDao userDao3 = ctx.getBean(UserDaoImpl3.class);
        userDao3.findAll().forEach(System.out::println);
    }
}
