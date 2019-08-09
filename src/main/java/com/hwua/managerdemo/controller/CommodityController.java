package com.hwua.managerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommodityController {

    @GetMapping("/commodityData")
    public String commodityData(){
        return "commoditydata";
    }
}