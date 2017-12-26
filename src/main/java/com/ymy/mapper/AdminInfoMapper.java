package com.ymy.mapper;

import com.ymy.model.AdminInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer id);

    List<AdminInfo> selectAll();

    int updateByPrimaryKey(AdminInfo record);
}