package com.hwua.managerdemo.service.impl;



import com.hwua.managerdemo.mapper.BrandMapper;
import com.hwua.managerdemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Map<String,Object>> queryBySid(String sid) {
        if(sid == null){
            return brandMapper.queryAll();
        }else{
            return brandMapper.queryBySid(Integer.parseInt(sid));
        }
    }

    @Override
    public Map<String, Object> queryByBid(Integer  bid) {
        return brandMapper.queryByBid(bid);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return brandMapper.queryAll();
    }

    @Override
    public List<Map<String, Object>> query() {
        return brandMapper.query();
    }

    @Override
    public List<Map<String, Object>> query4status() {
        return brandMapper.query4status();
    }

    @Override
    public Map<String, Object> queryByBName(String name) {
        return brandMapper.queryByBName(name);
    }

    @Override
    public boolean editBrand(Map<String, Object> param) {
        return brandMapper.editBrand(param) == 1;
    }

    @Override
    public boolean addBrand(Map<String, Object> param) {
        return brandMapper.addBrand(param) == 1;
    }

    @Override
    public boolean banBrand(Map<String, Object> param) {
        return brandMapper.banBrand(param) == 1;
    }


}
