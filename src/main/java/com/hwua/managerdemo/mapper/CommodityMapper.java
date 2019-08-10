package com.hwua.managerdemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CommodityMapper {

    int getCountAll();

    List<Map<String,Object>> query(Map<String,Object> param);


    List<Map<String,Object>> queryBySaleOrStock(@Param("sale") String sale, @Param("stock") String stock, @Param("cid") Integer cid);

    //修改商品库存和销量
    int updateStockAndSale(@Param("cid") Integer cid,@Param("quantity") Integer quantity);

    /**
     * 修改商品
     * @param param
     * @return
     */
    int editCommodity(Map<String,Object> param);

    /**
     * 添加商品
     * @param param
     * @return
     */
    int addCommodity(Map<String,Object> param);

    int deleteCommodity(Map<String,Object> param);
}
