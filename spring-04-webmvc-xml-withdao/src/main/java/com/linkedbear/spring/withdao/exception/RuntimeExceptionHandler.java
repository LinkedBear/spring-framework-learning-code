package com.linkedbear.spring.withdao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RuntimeExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        request.setAttribute("message", e.getMessage());
        return "error";
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        request.setAttribute("message", "[不合法的参数]" + e.getMessage());
        return "error";
    }
}
