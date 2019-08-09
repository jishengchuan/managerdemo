package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.managerdemo.service.PermissionService;
import com.hwua.managerdemo.service.RoleService;
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
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/roleData")
    public String roleData(Model model) {
        Map<String, Object> param = new HashMap<>();
        List<Map<String, Object>> roles = roleService.queryRoles(param);
        model.addAttribute("roles", roles);
        model.addAttribute("index", 3);
        return "roledata";
    }

    @PostMapping(value = "/queryRole", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryRole(Integer roleId) {
        if (roleId != null) {
            Map<String, Object> param = new HashMap<>();
            param.put("roleId", roleId);
            Map<String, Object> role = roleService.queryRole(param);
            return JSON.toJSONString(role);
        }
        return "{\"error\":false}";
    }

    @PostMapping(value = "/queryRolePermission", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryRolePermission(Integer roleId) {
        Map<String,Object> param = new HashMap<>();
        List<Map<String, Object>> allPermissions = permissionService.queryAllPermission();
        List<Map<String, Object>> permissions = permissionService.queryPermission(roleId);
        for (Map<String, Object> allPermission : allPermissions) {
            for (Map<String, Object> permission : permissions) {
                if (allPermission.get("permission_id").toString().equals(permission.get("permission_id").toString())) {
                    param.put(permission.get("type").toString(), true);
                }
            }
        }
        param.put("roleId",roleId);
        return JSON.toJSONString(param);
    }

    @PostMapping(value = "/addRoleAndPermission", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addRoleAndPermission(Integer roleId, Integer[] per){
        roleService.deleteRoleAndPermission(roleId);
        Map<String,Object> param = new HashMap<>();
        for (int i = 0; i < per.length; i++){
            param.put("roleId",roleId);
            param.put("permissionId",per[i]);
            roleService.addRoleAndPermission(param);
            param.clear();
        }
        return "{\"success\":true}";
    }

    @PostMapping(value = "/updateRole", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Integer roleId, String roleName, String description) {
        Map<String, Object> param = new HashMap<>();
        param.put("roleName", roleName);
        Map<String, Object> map = roleService.queryRole(param);
        if (map == null) {
            param.put("roleId", roleId);
            param.put("description", description);
            boolean b = roleService.doUpdate(param);
            return "{\"success\":" + b + "}";
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }

    @PostMapping(value = "/addRole", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addUser(String roleName, String description) {
        Map<String, Object> param = new HashMap<>();
        param.put("roleName", roleName);
        Map<String, Object> map = roleService.queryRole(param);
        if (map == null) {
            param.put("description", description);
            boolean b = roleService.addRole(param);
            return "{\"success\":" + b + "}";
        }
        param.put("success", false);
        return JSON.toJSONString(param);
    }

    @PostMapping(value = "/banRole", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String ban(Integer roleId, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("status", status.equals("1") ? 0 : 1);
        boolean ban = roleService.ban(map);
        return "{\"success\":" + ban + "}";
    }
}
