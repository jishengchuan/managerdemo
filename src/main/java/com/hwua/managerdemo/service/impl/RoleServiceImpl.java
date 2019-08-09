package com.hwua.managerdemo.service.impl;

import com.hwua.managerdemo.mapper.RoleMapper;
import com.hwua.managerdemo.mapper.UserMapper;
import com.hwua.managerdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> queryRoles(Map<String, Object> param) {
        return roleMapper.queryRoles(param);
    }

    @Override
    public Map<String, Object> queryRole(Map<String, Object> param) {
        return roleMapper.queryRole(param);
    }

    @Override
    public boolean addRole(Map<String, Object> role) {
        return roleMapper.insertRole(role) == 1;
    }

    @Override
    public boolean addRoleAndPermission(Map<String, Object> param) {
        return roleMapper.insertRoleAndPermission(param) == 1;
    }

    @Override
    public boolean deleteRoleAndPermission(Integer roleId) {
        return roleMapper.deleteRoleAndPermission(roleId) == 1;
    }

    @Override
    public boolean doUpdate(Map<String, Object> param) {
        return roleMapper.doUpdate(param) == 1;
    }

    @Override
    public boolean ban(Map<String, Object> param) {
        return roleMapper.ban(param) == 1;
    }
}
