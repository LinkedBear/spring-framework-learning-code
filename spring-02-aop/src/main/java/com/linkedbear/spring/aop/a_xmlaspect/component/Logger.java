package com.linkedbear.spring.aop.a_xmlaspect.component;

public class Logger {
    
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }
    
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }
    
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }
    
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }
}
