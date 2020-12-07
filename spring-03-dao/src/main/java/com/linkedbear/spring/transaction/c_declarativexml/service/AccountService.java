package com.linkedbear.spring.transaction.c_declarativexml.service;

import com.linkedbear.spring.transaction.c_declarativexml.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;
    
    public void transfer(String sourceId, String targetId, int money) {
        accountDao.subtractMoney(sourceId, money);
        
        int i = 1 / 0;
        
        accountDao.addMoney(targetId, money);
    }
}
