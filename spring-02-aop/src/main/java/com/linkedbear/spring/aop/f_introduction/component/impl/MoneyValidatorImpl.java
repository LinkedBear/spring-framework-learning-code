package com.linkedbear.spring.aop.f_introduction.component.impl;

import com.linkedbear.spring.aop.f_introduction.component.MoneyValidator;
import org.springframework.stereotype.Component;

@Component
public class MoneyValidatorImpl implements MoneyValidator {
    
    @Override
    public boolean validate(int money) {
        return money > 0;
    }
}
