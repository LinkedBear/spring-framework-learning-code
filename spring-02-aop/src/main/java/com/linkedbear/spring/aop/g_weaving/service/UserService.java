package com.linkedbear.spring.aop.g_weaving.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public void get(String id) {
        System.out.println("获取id为" + id + "的用户。。。");
    }
}
