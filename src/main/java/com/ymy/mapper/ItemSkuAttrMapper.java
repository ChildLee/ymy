package com.ymy.mapper;

import com.ymy.model.ItemSkuAttr;

import java.util.List;

public interface ItemSkuAttrMapper {
    int deleteByPrimaryKey(Integer itemAttrId);

    int insert(ItemSkuAttr record);

    ItemSkuAttr selectByPrimaryKey(Integer itemAttrId);

    List<ItemSkuAttr> selectAll();

    int updateByPrimaryKey(ItemSkuAttr record);
}