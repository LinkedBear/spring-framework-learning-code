package com.linkedbear.spring.transaction.f_listener.service;

import com.linkedbear.spring.jdbc.b_crud.bean.User;
import com.linkedbear.spring.transaction.f_listener.dao.UserDao;
import com.linkedbear.spring.transaction.f_listener.event.UserSaveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    @Autowired
    ApplicationEventPublisher eventPublisher;
    
    @Transactional
    public void saveUser() {
        User user = new User();
        user.setName("哈哈哈");
        user.setTel("123");
    
        userDao.save(user);
        System.out.println("User save ......");
//        eventPublisher.publishEvent(user);
//        int i = 1 / 0;
        
        eventPublisher.publishEvent(new UserSaveEvent(user));
    }
}
