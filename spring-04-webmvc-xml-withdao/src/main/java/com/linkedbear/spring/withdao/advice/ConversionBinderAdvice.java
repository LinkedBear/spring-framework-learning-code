package com.linkedbear.spring.withdao.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//@ControllerAdvice
public class ConversionBinderAdvice {
    
    @InitBinder
    public void addDateBinder(WebDataBinder dataBinder) {
        System.out.println("@InitBinder addDateBinder ......");
        dataBinder.addCustomFormatter(new DateFormatter("yyyy年MM月dd日"));
    }
}
