package com.linkedbear.spring.aop.e_aopcontext.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
//    @Autowired
//    UserService userService;
    
    public void update(String id, String name) {
//        this.get(id);
//        userService.get(id);
        ((UserService) AopContext.currentProxy()).get(id);
        System.out.println("修改指定id的name。。。");
    }
    
    public void get(String id) {
        System.out.println("获取指定id的user。。。");
    }
}
