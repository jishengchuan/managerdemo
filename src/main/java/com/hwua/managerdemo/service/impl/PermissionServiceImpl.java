package com.hwua.managerdemo.service.impl;

import com.hwua.managerdemo.mapper.PermissionMapper;
import com.hwua.managerdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Map<String, Object>> queryPermission(Integer roleId) {
        return permissionMapper.queryPermission(roleId);
    }

    @Override
    public List<Map<String, Object>> queryAllPermission() {
        return permissionMapper.queryAllPermission();
    }
}
