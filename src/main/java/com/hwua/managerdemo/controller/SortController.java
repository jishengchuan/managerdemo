package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.managerdemo.service.SortService;
import com.hwua.managerdemo.service.SortService;
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
public class SortController {

    @Autowired
    private SortService sortService;

    @GetMapping("/sortData")
    public String sorts(Model model){
        List<Map<String, Object>> sorts = sortService.queryAll();
        model.addAttribute("sorts",sorts);
        model.addAttribute("index",6);
        return "sortdata";
    }

    @PostMapping(value = "/updateSortForm", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String querySort(Integer sortId){
        if (sortId != null) {
            Map<String, Object> map = sortService.queryBySid(sortId);
            return JSON.toJSONString(map);
        }
        return "{\"error\":false}";
    }


    @PostMapping(value = "/updateSort", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String editSort(Integer sortId,String sortName){
        Map<String,Object> sort = new HashMap<>();
        sort.put("sortId",sortId);
        sort.put("sortName",sortName);
        boolean b = sortService.editSort(sort);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/addSort", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addSort(String sortName){
        Map<String,Object> sort = new HashMap<>();
        sort.put("sortName",sortName);
        boolean b = sortService.addSort(sort);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/banSort", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String banSort(Integer sortId, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("sortId", sortId);
        map.put("status", status.equals("1") ? 0 : 1);
        boolean ban = sortService.banSort(map);
        return "{\"success\":" + ban + "}";
    }

}
