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
    public List<Map<String,Object>> query(String name, String sid,String bid, String desc,Integer page) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("sid",sid);
        map.put("bid",bid);
        map.put("desc",desc);
        //开始分页
        if (page!=null){
            PageHelper.startPage(page,8);
        }
        return commodityMapper.query(map);
    }


    @Override
    public Map<String,Object> queryByCid(Integer cid) {
        return commodityMapper.queryBySaleOrStock(null,null,cid).get(0);
    }

    @Override
    public List<Map<String, Object>> querySaleAndStock(String sale, String stock,Integer page) {
        if (page != null){
            PageHelper.startPage(page,3);
        }
        return commodityMapper.queryBySaleOrStock(sale,stock,null);
    }

    @Override
    public Map<String, Object> queryCidByStock(Integer cid) {
        return commodityMapper.queryBySaleOrStock(null,null,cid).get(0);
    }

    @Override
    public boolean addCommodity(Map<String, Object> param) {
        return commodityMapper.addCommodity(param) == 1;
    }

    @Override
    public boolean editCommodity(Map<String, Object> param) {
        return commodityMapper.editCommodity(param) == 1;
    }

    @Override
    public boolean deleteCommodity(Map<String, Object> param) {
        return commodityMapper.deleteCommodity(param) == 1;
    }

    @Override
    public boolean ban(Map<String, Object> param) {
        return commodityMapper.deleteCommodity(param) == 1;
    }


}
