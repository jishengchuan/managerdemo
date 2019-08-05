package com.hwua.managerdemo.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CommodityMapper {

    /**
     * 关于商品的查询;如品牌,分类.名字...
     * @param param 查询需要的参数
     * @return
     */
    List<Map<String,Object>> query(Map<String,Object> param);
}
