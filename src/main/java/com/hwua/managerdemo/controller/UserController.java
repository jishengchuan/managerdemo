package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.managerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/logindemo")
    public String logindemo(){
        return "logindemo";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doLogin(String username, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        Map<String, Object> login = userService.login(map);
        if (login.containsKey("error")){
            return JSON.toJSONString(login);
        }
        List<Map<String,Object>> permission = userService.queryPermission(Integer.parseInt(login.get("role_id").toString()));
        for (Map<String, Object> stringObjectMap : permission) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
        session.setAttribute("permissions",permission);
        session.setAttribute("user",login);
        map = new HashMap<>();
        map.put("success",true);
        return JSON.toJSONString(map);
    }

    @GetMapping("/userData")
    public String userData(Model model){
        List<Map<String, Object>> query = userService.query();
        System.out.println("query = " + query);
        for (Map<String, Object> stringObjectMap : query) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
        model.addAttribute("users",query);
        return "data";
    }

    @GetMapping("/user")
    public String user(Model model){
        Map<String,Object> query = userService.query4One(1002);
        List<Map<String,Object>> permission = userService.queryPermission(Integer.parseInt(query.get("role_id").toString()));
        for (Map<String, Object> stringObjectMap : permission) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
        model.addAttribute("permissions",permission);
        model.addAttribute("users",query);
        return "data";
    }


}
