package com.ymy.mapper;

import com.ymy.model.ShopOrder;

import java.util.List;

public interface ShopOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopOrder record);

    ShopOrder selectByPrimaryKey(Integer id);

    List<ShopOrder> selectAll();

    int updateByPrimaryKey(ShopOrder record);
}