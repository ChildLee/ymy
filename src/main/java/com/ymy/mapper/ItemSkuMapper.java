package com.ymy.mapper;

import com.ymy.model.ItemSku;

import java.util.List;

public interface ItemSkuMapper {
    int deleteByPrimaryKey(Integer skuId);

    int insert(ItemSku record);

    ItemSku selectByPrimaryKey(Integer skuId);

    List<ItemSku> selectAll();

    int updateByPrimaryKey(ItemSku record);
}