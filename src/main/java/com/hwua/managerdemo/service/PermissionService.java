package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    List<Map<String,Object>> queryPermission(Integer roleId);

    List<Map<String,Object>> queryAllPermission();
}
