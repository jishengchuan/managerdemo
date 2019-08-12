package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.managerdemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brandData")
    public String brands(Model model){
        List<Map<String, Object>> brands = brandService.query();
        model.addAttribute("brands",brands);
        model.addAttribute("index",5);
        return "branddata";
    }

    @PostMapping(value = "/updateBrandForm", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryBrand(Integer brandId){
        if (brandId != null) {
            Map<String, Object> map = brandService.queryByBid(brandId);
            return JSON.toJSONString(map);
        }
        return "{\"error\":false}";
    }


    @PostMapping(value = "/updateBrand", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String editBrand(Integer brandId,String brandName){
        Map<String,Object> brand = new HashMap<>();
        brand.put("brandId",brandId);
        brand.put("brandName",brandName);
        boolean b = brandService.editBrand(brand);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/addBrand", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addBrand(String brandName){
        Map<String,Object> brand = new HashMap<>();
        brand.put("brandName",brandName);
        boolean b = brandService.addBrand(brand);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/banBrand", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String banBrand(Integer brandId, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("brandId", brandId);
        map.put("status", status.equals("1") ? 0 : 1);
        boolean ban = brandService.banBrand(map);
        return "{\"success\":" + ban + "}";
    }

}
