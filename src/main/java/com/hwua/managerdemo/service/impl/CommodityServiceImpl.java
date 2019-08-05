package com.hwua.managerdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hwua.managerdemo.mapper.CommodityMapper;
import com.hwua.managerdemo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<Map<String, Object>> query(String name, String sid,String bid, String desc,Integer page) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("sid",sid);
        map.put("bid",bid);
        map.put("desc",desc);
        //开始分页
        if (page!=null){
            PageHelper.startPage(page,5);
        }
        return commodityMapper.query(map);
    }
}
