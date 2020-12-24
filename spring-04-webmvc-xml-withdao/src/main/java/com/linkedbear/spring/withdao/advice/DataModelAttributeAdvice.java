package com.linkedbear.spring.withdao.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

//@ControllerAdvice
public class DataModelAttributeAdvice {
    
    @ModelAttribute("publicMessage")
    public String publicMessage() {
        return "publicMessage-hahaha";
    }
    
    @ModelAttribute("username")
    public String processUsername(String username) {
        return username + "haha";
    }
    
    /*
    public void processUsername(Model model) {
        String username = (String) model.getAttribute("username");
        username += "haha";
        model.addAttribute("username", username);
    }
    */
}
