package com.linkedbear.spring.event.b_registerevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * 注册成功的事件
 */
public class RegisterSuccessEvent extends ApplicationEvent {
    
    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
