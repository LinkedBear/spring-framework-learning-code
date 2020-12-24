package com.linkedbear.spring.a_quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}
