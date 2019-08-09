package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PermissionMapper {

    /**
     * 根据角色Id查询权限
     * @param roleId
     * @return
     */
    List<Map<String,Object>> queryPermission(Integer roleId);

    /**
     * 查询全部权限
     * @return
     */
    List<Map<String,Object>> queryAllPermission();
}
