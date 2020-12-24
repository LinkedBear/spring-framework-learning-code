package com.linkedbear.spring.withdao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class SessionAttributeController {
    
    @GetMapping("/session/username")
    public String sessionUsername(Model model) {
        model.addAttribute("username", "hahaha");
        return "session";
    }
    
    @GetMapping("/session/get")
    @ResponseBody
    public String getSessionUsername(@SessionAttribute("username") String username) {
        return username;
    }
}
