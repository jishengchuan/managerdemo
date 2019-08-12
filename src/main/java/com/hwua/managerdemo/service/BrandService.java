package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface BrandService {
    //根据分类id，查询分类中的品牌
    List<Map<String,Object>> queryBySid(String sid);
    //根据品牌id查询
    Map<String, Object> queryByBid(Integer bid);

    List<Map<String,Object>> queryAll();

    List<Map<String,Object>> query();

    List<Map<String,Object>> query4status();

    Map<String,Object> queryByBName(String name);

    boolean editBrand(Map<String,Object> param);

    boolean addBrand(Map<String,Object> param);

    boolean banBrand(Map<String,Object> param);
}
