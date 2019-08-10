package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SortMapper {
    /**
     * 导航：查询至少有一个商品的分类
     * @return
     */
    List<Map<String,Object>> queryNav();

    //根据id查询分类
    Map<String, Object > queryBySid(Integer sid);

    Map<String,Object> queryBySName(String sortName);
}
