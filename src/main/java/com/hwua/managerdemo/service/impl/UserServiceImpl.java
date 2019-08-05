package com.hwua.managerdemo.service.impl;

import com.hwua.managerdemo.mapper.UserMapper;
import com.hwua.managerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> query() {
        Map<String,Object> map = new HashMap<>();
        return userMapper.query4User(map);
    }

    @Override
    public Map<String, Object> query4One(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        return userMapper.query4One(map);
    }

    @Override
    public List<Map<String,Object>> queryPermission(Integer roleId) {
        return userMapper.queryPermission(roleId);
    }

    @Override
    public Map<String, Object> queryByUsername(String username) {
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        Map<String, Object> map = userMapper.query4One(param);
        if(map == null){
            //可以添加
            map = new HashMap<>();
            map.put("success",true);
        }else{
            //不可以添加，已有此用户名
            map.clear();
            map.put("error","用户名已存在");
        }
        return map;
    }

    @Override
    public Map<String, Object> login(Map<String, Object> param) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("username",param.get("username"));
        Object password = param.get("password");
        maps.put("password",param.get("password"));
        Map<String, Object> map = userMapper.query4One(maps);
        if(map == null) {
            //登录失败，用户名不存在
            map = new HashMap<>();
            map.put("error", "用户名不存在");
        }else {
            if(map.get("password").equals(password)) {
                //登录成功
                return map;
            }else {
                //登录失败，密码错误
                map.clear();
                map.put("error", "密码错误");
            }
        }
        return map;
    }

}
