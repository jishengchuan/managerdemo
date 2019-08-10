package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface SortService {
    //根据id查询分类
    Map<String, Object> queryBySid(Integer sid);

    List<Map<String,Object>> queryAll();

    Map<String,Object> queryBySName(String name);
}
