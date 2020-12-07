package com.linkedbear.spring.transaction.d_declarativeanno.service;

import com.linkedbear.spring.jdbc.b_crud.bean.User;
import com.linkedbear.spring.transaction.d_declarativeanno.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    @Transactional
    public void saveAndQuery() {
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");
    
        userDao.save(user);

        int i = 1 / 0;

        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
}
