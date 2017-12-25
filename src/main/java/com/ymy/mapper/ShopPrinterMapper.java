package com.ymy.mapper;

import com.ymy.model.ShopPrinter;

import java.util.List;

public interface ShopPrinterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopPrinter record);

    ShopPrinter selectByPrimaryKey(Integer id);

    List<ShopPrinter> selectAll();

    int updateByPrimaryKey(ShopPrinter record);
}