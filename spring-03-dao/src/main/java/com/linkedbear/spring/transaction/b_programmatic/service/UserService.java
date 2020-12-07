package com.linkedbear.spring.transaction.b_programmatic.service;

import com.linkedbear.spring.jdbc.b_crud.bean.User;
import com.linkedbear.spring.transaction.b_programmatic.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    TransactionTemplate transactionTemplate;
    
    @Autowired
    UserDao userDao;
    
    public void saveAndQuery() {
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");
    
//        userDao.save(user);
//
//        int i = 1 / 0;
//
//        List<User> userList = userDao.findAll();
//        System.out.println(userList);

//          transactionTemplate.execute(status -> {
//              userDao.save(user);
//
//              int i = 1 / 0;
//
//              List<User> userList = userDao.findAll();
//              System.out.println(userList);
//              return null;
//          });

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                userDao.save(user);

                int i = 1 / 0;

                List<User> userList = userDao.findAll();
                System.out.println(userList);
            }
        });
    }
}
