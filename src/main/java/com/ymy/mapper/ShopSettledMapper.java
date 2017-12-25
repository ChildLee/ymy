package com.ymy.mapper;

import com.ymy.model.ShopSettled;

import java.util.List;

public interface ShopSettledMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopSettled record);

    ShopSettled selectByPrimaryKey(Integer id);

    List<ShopSettled> selectAll();

    int updateByPrimaryKey(ShopSettled record);
}