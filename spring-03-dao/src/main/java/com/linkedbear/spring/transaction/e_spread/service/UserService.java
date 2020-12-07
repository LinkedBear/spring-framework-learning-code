package com.linkedbear.spring.transaction.e_spread.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class UserService {
    
    @Autowired
    PointService pointService;
    
    @Transactional
    public void register() {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        // 持久化操作 ......
        System.out.println("register 注册用户 ......");
        pointService.addPoint();
    }
}
