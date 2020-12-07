package com.linkedbear.spring.jdbc.c_dao.dao;

import com.linkedbear.spring.jdbc.b_crud.bean.User;

import java.util.List;

public interface UserDao {
    
    void save(User user);
    
    User findById(Integer id);
    
    List<User> findAll();
}
