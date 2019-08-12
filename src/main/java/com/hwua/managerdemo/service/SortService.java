package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface SortService {
    //根据id查询分类
    Map<String, Object> queryBySid(Integer sid);

    List<Map<String,Object>> queryAll();

    List<Map<String,Object>> query4status();

    Map<String,Object> queryBySName(String name);

    /**
     * 修改分类
     * @param param
     * @return
     */
    boolean editSort(Map<String,Object> param);

    /**
     * 添加分类
     * @param param
     * @return
     */
    boolean addSort(Map<String,Object> param);

    boolean banSort(Map<String,Object> param);
}
