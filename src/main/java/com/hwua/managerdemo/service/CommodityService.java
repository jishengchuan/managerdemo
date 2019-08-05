package com.hwua.managerdemo.service;

import java.util.List;
import java.util.Map;

public interface CommodityService {

    /**
     * 关于商品的查询;如品牌,分类.名字...
     * @param name
     * @param sid
     * @param bid
     * @param desc
     * @param page
     * @return
     */
    List<Map<String, Object>> query(String name, String sid,String bid, String desc,Integer page);
}
