package com.linkedbear.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @GetMapping("/findAll")
    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.query("select * from tbl_dept", new ColumnMapRowMapper());
    }
}
