package com.ymy.mapper;

import com.ymy.model.Shop;

import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    Shop selectByPrimaryKey(Integer id);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);
}