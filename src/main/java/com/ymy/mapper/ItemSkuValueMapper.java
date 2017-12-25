package com.ymy.mapper;

import com.ymy.model.ItemSkuValue;

import java.util.List;

public interface ItemSkuValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemSkuValue record);

    ItemSkuValue selectByPrimaryKey(Integer id);

    List<ItemSkuValue> selectAll();

    int updateByPrimaryKey(ItemSkuValue record);
}