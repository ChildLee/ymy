package com.ymy.mapper;

import com.ymy.model.Items;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    Items selectByPrimaryKey(Integer id);

    List<Items> selectAll();

    int updateByPrimaryKey(Items record);
}