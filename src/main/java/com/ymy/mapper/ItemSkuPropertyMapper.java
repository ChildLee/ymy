package com.ymy.mapper;

import com.ymy.model.ItemSkuProperty;

import java.util.List;

public interface ItemSkuPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemSkuProperty record);

    ItemSkuProperty selectByPrimaryKey(Integer id);

    List<ItemSkuProperty> selectAll();

    int updateByPrimaryKey(ItemSkuProperty record);
}