package com.hwua.managerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.github.pagehelper.Page;
import com.hwua.managerdemo.service.BrandService;
import com.hwua.managerdemo.service.CommodityService;
import com.hwua.managerdemo.service.SortService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private SortService sortService;

    @GetMapping("/commodityData")
    public String list(String name, String sid, String bid, String desc, @RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        List<Map<String, Object>> query = commodityService.query(name, sid, bid, desc, page);
        model.addAttribute("list", query);
        List<Map<String, Object>> brands = brandService.queryBySid(sid);
        model.addAttribute("brands", brands);
        List<Map<String, Object>> allBrand = brandService.queryAll();
        model.addAttribute("allBrand", allBrand);
        List<Map<String, Object>> sorts = sortService.queryAll();
        model.addAttribute("allSort", sorts);
        //判断query是否是Page类是子类或者子类实例
        if (query instanceof Page) {
            Page commodityPage = (Page) query;
            //当前页数
            int pageNum = commodityPage.getPageNum();
            //总页数
            int pages = commodityPage.getPages();
            model.addAttribute("pageNum", pageNum);
            model.addAttribute("pages", pages);
            model.addAttribute("index", 4);
        }
        return "commoditydata";
    }

    @PostMapping(value = "/queryCommodity", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateCommodity(Integer commodityId) {
        Map<String, Object> map = commodityService.queryByCid(commodityId);
        if (map != null) {
            Map<String, Object> brand = brandService.queryByBid(Integer.parseInt(map.get("brand_id").toString()));
            Map<String, Object> sort = sortService.queryBySid(Integer.parseInt(map.get("sort_id").toString()));
            map.put("brandName", brand.get("brand_name"));
            map.put("sortName", sort.get("sort_name"));
            return JSON.toJSONString(map);
        }
        return "{\"error\":false}";
    }

    @PostMapping(value = "/updateCommodity", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Integer commodityId, String commodityName, Double price, String brand, String sort, String stock, String sale) {
        Map<String, Object> brands = brandService.queryByBName(brand);
        Map<String, Object> sorts = sortService.queryBySName(sort);
        Map<String, Object> param = new HashMap<>();
        param.put("commodityId", commodityId);
        param.put("commodityName", commodityName);
        param.put("commodityPrice", price);
        param.put("sale", sale);
        param.put("stock", stock);
        param.put("brandId", brands.get("brand_id"));
        param.put("sortId", sorts.get("sort_id"));
        commodityService.editCommodity(param);
        return "{\"success\":true}";
    }

    @PostMapping(value = "/addCommodity", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(String commodityName, Double price, String brand, String sort, String stock, String sale) {
        Map<String, Object> brands = brandService.queryByBName(brand);
        if(brands == null){
            return "{\"success\":false}";
        }
        Map<String, Object> sorts = sortService.queryBySName(sort);
        Map<String, Object> param = new HashMap<>();
        param.put("commodityName", commodityName);
        param.put("commodityPrice", price);
        param.put("sale", sale);
        param.put("stock", stock);
        param.put("brandId", brands.get("brand_id"));
        param.put("sortId", sorts.get("sort_id"));
        boolean b = commodityService.addCommodity(param);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/banCommodity", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String ban(Integer commodityId, String status) {
        Map<String, Object> map = new HashMap<>();
        map.put("commodityId", commodityId);
        map.put("status", status.equals("1") ? 0 : 1);
        boolean ban = commodityService.ban(map);
        return "{\"success\":" + ban + "}";
    }
}