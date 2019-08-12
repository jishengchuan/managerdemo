package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BrandMapper {
    //查询全部有商品的品牌
    List<Map<String,Object>> queryAll();

    //查询全部品牌
    List<Map<String,Object>> query();

    /**
     * 根据状态查询
     * @return
     */
    List<Map<String,Object>> query4status();
    //根据分类id，查询分类中的品牌
    List<Map<String,Object>> queryBySid(Integer sid);
    //根据id查询品牌
    Map<String, Object> queryByBid(Integer bid);

    Map<String,Object> queryByBName(String brandName);

    int addBrand(Map<String,Object> param);

    int editBrand(Map<String,Object> param);

    int banBrand(Map<String,Object> param);
}
