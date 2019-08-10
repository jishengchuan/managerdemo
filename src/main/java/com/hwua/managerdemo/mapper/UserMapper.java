package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {
    /**
     * 根据用户名，等查询用户
     * @param param
     * @return
     */
    Map<String,Object> query4One(Map<String,Object> param);

    /**
     * 查询全部或者跟根据某一特点查询
     * @param param
     * @return
     */
    List<Map<String,Object>> query4User(Map<String,Object> param);

    /**
     * 查询可用角色(比自身id小)
     * @param roleId
     * @return
     */
    List<Map<String,Object>> queryRoles(Integer roleId);

    /**
     * 更新用户基础信息
     * @param param
     * @return
     */
    int doUpdate(Map<String,Object> param);

    /**
     *禁用或启用用户
     * @param param
     * @return
     */
    int ban(Map<String,Object> param);

    /**
     * 创建用户
     * @param user 新建用户数据
     * @return
     */
    int insertUser(Map<String,Object> user);

    /**
     * 将新建用户的角色插入sys_user_role表中
     * @param param
     * @return
     */
    int insertUserAndRole(Map<String,Object> param);

    /**
     * 修改时先删除用户和角色的关系
     * @param param
     * @return
     */
    int deleteUserAndRole(Map<String,Object> param);

}
