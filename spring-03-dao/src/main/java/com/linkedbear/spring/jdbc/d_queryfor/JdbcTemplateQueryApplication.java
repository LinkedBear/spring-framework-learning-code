package com.linkedbear.spring.jdbc.d_queryfor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplateQueryApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        // JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        
        // 这样写不可以，会抛出异常：Incorrect column count: expected 1, actual 3
        // List<User> userList = jdbcTemplate.queryForList("select * from tbl_user", User.class);
        
        // List<String> userList = jdbcTemplate.queryForList("select name from tbl_user", String.class);
        // List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from tbl_user where id > ?", 3);
        // userList.forEach(System.out::println);
    
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ctx.getBean(DataSource.class));
        Map<String, Object> params = new HashMap<>();
        params.put("id", 3);
        params.put("name", "ha%");
        List<Map<String, Object>> userList = jdbcTemplate
                .queryForList("select * from tbl_user where id > :id and name like :name", params);
        userList.forEach(System.out::println);
    }
}














