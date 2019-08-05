package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {
    /**
     * 根据用户名，
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

    List<Map<String,Object>> queryPermission(Integer roleId);

    boolean doInsert(Map<String,Object> user);
}
