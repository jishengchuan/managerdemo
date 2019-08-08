package com.hwua.managerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/starter")
    public String starter() {
        return "starter";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("index",1);
        return "index";
    }
    
}
