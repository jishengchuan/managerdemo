package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BrandMapper {
    //查询全部品牌
    List<Map<String,Object>> queryAll();
    //根据分类id，查询分类中的品牌
    List<Map<String,Object>> queryBySid(Integer sid);
    //根据id查询品牌
    Map<String, Object> queryByBid(Integer bid);

    Map<String,Object> queryByBName(String brandName);
}
