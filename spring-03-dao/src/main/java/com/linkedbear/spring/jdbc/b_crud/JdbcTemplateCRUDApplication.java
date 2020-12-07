package com.linkedbear.spring.jdbc.b_crud;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateCRUDApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
//        int row = jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", "heihei", "200");
//        int row = jdbcTemplate.update("update tbl_user set tel = ? where name = ?", "54321", "heihei");
//        int row = jdbcTemplate.update("delete from tbl_user where name = ?", "heihei");
//        System.out.println(row);
//
//        List<User> userList = jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
//        List<User> userList = jdbcTemplate.query("select * from tbl_user where id > ?", new BeanPropertyRowMapper<>(User.class), 2);
//        userList.forEach(System.out::println);
//
//        List<User> userList = jdbcTemplate.query("select * from tbl_user where id = ?", new BeanPropertyRowMapper<>(User.class), 2);
//        User user = userList.size() > 0 ? userList.get(0) : null;
//        System.out.println(user);
    
        Long count = jdbcTemplate.queryForObject("select count(id) from tbl_user", Long.class);
        System.out.println(count);
    }
}
