package com.ymy.mapper;

import com.ymy.model.AdminInfo;

import java.util.List;

public interface AdminInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer id);

    List<AdminInfo> selectAll();

    int updateByPrimaryKey(AdminInfo record);
}