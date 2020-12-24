package com.linkedbear.spring.withdao.service;

import com.linkedbear.spring.withdao.dao.UserDao;
import com.linkedbear.spring.withdao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public void update(User user) {
        userDao.update(user);
    }
    
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
    
    public User findById(String id) {
        return userDao.findById(id);
    }
}
