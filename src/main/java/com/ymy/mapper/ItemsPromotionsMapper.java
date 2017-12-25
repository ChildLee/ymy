package com.ymy.mapper;

import com.ymy.model.ItemsPromotions;

import java.util.List;

public interface ItemsPromotionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemsPromotions record);

    ItemsPromotions selectByPrimaryKey(Integer id);

    List<ItemsPromotions> selectAll();

    int updateByPrimaryKey(ItemsPromotions record);
}