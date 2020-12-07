package com.linkedbear.spring.transaction.d_declarativeanno.service;

import com.linkedbear.spring.transaction.d_declarativeanno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountDao accountDao;
    
    public void transfer(Integer sourceId, Integer targetId, int money) {
        accountDao.subtractMoney(sourceId, money);
        
        int i = 1 / 0;
        
        accountDao.addMoney(targetId, money);
    }
}
