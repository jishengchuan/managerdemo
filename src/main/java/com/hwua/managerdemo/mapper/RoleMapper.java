package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper {

    /**
     * 查询可用角色
     * @param param
     * @return
     */
    List<Map<String,Object>> queryRoles(Map<String,Object> param);

    /**
     * 根据角色名字,等查询角色
     * @param param
     * @return
     */
    Map<String,Object> queryRole(Map<String,Object> param);

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    int doUpdate(Map<String,Object> param);

    /**
     * 插入角色信息
     * @param Role
     * @return
     */
    int insertRole(Map<String,Object> Role);

    /**
     * 更改角色状态
     * @param param
     * @return
     */
    int ban(Map<String,Object> param);

    /**
     * 插入角色权限信息
     * @param param
     * @return
     */
    int insertRoleAndPermission(Map<String,Object> param);
}
