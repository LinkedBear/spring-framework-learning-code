package com.linkedbear.spring.aop.c_joinpoint.service;

import com.linkedbear.spring.aop.c_joinpoint.component.Log;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
    
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }
    
    @Log
    public double subtractMoney(double money) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double subtractMoney(double money, String id) throws Exception {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }
}
