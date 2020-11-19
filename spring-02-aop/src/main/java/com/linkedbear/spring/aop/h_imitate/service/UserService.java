package com.linkedbear.spring.aop.h_imitate.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public void get(String id) {
        System.out.println("获取id为" + id + "的用户。。。");
    }
    
    public void save(String name) {
        System.out.println("保存name为" + name + "的用户。。。");
    }
}
