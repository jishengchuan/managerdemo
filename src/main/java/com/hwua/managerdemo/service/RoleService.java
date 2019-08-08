package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Map<String,Object>> queryRoles(Map<String,Object> param);

    Map<String,Object> queryRole(Map<String,Object> param);

    boolean addRole(Map<String,Object> role);

    boolean doUpdate(Map<String,Object> param);

    boolean ban(Map<String,Object> param);
}
