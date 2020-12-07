package com.linkedbear.spring.transaction.f_listener.event;

import org.springframework.context.ApplicationEvent;

public class UserSaveEvent extends ApplicationEvent {
    
    public UserSaveEvent(Object source) {
        super(source);
    }
}
