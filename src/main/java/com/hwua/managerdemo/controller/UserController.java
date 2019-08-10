package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.managerdemo.service.PermissionService;
import com.hwua.managerdemo.service.RoleService;
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
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doLogin(String username, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        Map<String, Object> login = userService.login(map);
        if (login.containsKey("error")) {
            return JSON.toJSONString(login);
        }
        List<Map<String, Object>> permission = permissionService.queryPermission(Integer.parseInt(login.get("role_id").toString()));
        session.setAttribute("permissions", permission);
        session.setAttribute("user", login);
        map = new HashMap<>();
        map.put("success", true);
        return JSON.toJSONString(map);
    }

    @GetMapping("/userData")
    public String userData(Integer userId, String username, Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);
        List<Map<String, Object>> query = userService.query(map);
        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
        List<Map<String, Object>> roles = userService.queryRoles(Integer.parseInt(user.get("role_id").toString()));
        model.addAttribute("roles", roles);
        model.addAttribute("users", query);
        model.addAttribute("index", 2);
        return "data";
    }

    @PostMapping(value = "/updateForm", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Integer userId) {
        if (userId != null) {
            Map<String, Object> user = userService.query4One(userId);
            return JSON.toJSONString(user);
        }
        return "{\"error\":false}";
    }

    @PostMapping(value = "/updateUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Integer userId, String username, String tel, String email,String roleName) {
        Map<String, Object> map = userService.queryByUsername(username);
        if (!map.containsKey("error")) {
            Map<String, Object> param = new HashMap<>();
            param.put("userId", userId);
            userService.deleteUserAndRole(param);
            param.put("username", username);
            param.put("tel", tel);
            param.put("email", email);
            param.put("roleName",roleName);
            boolean b = userService.doUpdate(param);
            return "{\"success\":" + b + "}";
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }

    @PostMapping(value = "/addUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addUser(String username, String password, String tel, String email, String photo, String roleName) {
        Map<String, Object> map = userService.queryByUsername(username);
        if (!map.containsKey("error")) {
            Map<String, Object> user = new HashMap<>();
            user.put("username", username);
            user.put("password", password);
            user.put("tel", tel);
            user.put("email", email);
            user.put("photo", photo);
            user.put("roleName", roleName);
            boolean b = userService.insertUser(user);
            return "{\"success\":" + b + "}";
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }

    @PostMapping(value = "/ban", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String ban(Integer userId, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("status", status.equals("1") ? 0 : 1);
        boolean ban = userService.ban(map);
        return "{\"success\":" + ban + "}";
    }
}
