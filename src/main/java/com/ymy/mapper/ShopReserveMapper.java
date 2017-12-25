package com.ymy.mapper;

import com.ymy.model.ShopReserve;

import java.util.List;

public interface ShopReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopReserve record);

    ShopReserve selectByPrimaryKey(Integer id);

    List<ShopReserve> selectAll();

    int updateByPrimaryKey(ShopReserve record);
}