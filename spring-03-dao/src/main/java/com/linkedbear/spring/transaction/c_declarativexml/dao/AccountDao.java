package com.linkedbear.spring.transaction.c_declarativexml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void addMoney(String userId, int money) {
        jdbcTemplate.update("update tbl_account set money = money + ? where user_id = ?", money, userId);
    }
    
    public void subtractMoney(String userId, int money) {
        jdbcTemplate.update("update tbl_account set money = money - ? where user_id = ?", money, userId);
    }
}
