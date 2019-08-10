package com.hwua.managerdemo.service.impl;


import com.hwua.managerdemo.mapper.SortMapper;
import com.hwua.managerdemo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sortService")
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    @Override
    public Map<String, Object> queryBySid(Integer sid) {
        return sortMapper.queryBySid(sid);
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return sortMapper.queryNav();
    }

    @Override
    public Map<String, Object> queryBySName(String name) {
        return sortMapper.queryBySName(name);
    }
}
