package com.linkedbear.spring.event.b_registerevent.listener;

import com.linkedbear.spring.event.b_registerevent.event.RegisterSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderListener {
    
    @EventListener
    @Order(0)
    public void onRegisterSuccess(RegisterSuccessEvent event) {
        System.out.println("监听到用户注册成功，发送站内信。。。");
    }
}
