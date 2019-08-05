package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String,Object>> query();

    Map<String,Object> query4One(Integer userId);

    List<Map<String,Object>> queryPermission(Integer roleId);

    Map<String,Object> queryByUsername(String username);

    Map<String,Object> login(Map<String,Object> param);
}
