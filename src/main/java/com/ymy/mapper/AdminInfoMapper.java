package com.ymy.mapper;

import com.ymy.model.AdminInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInfoMapper {
    List<AdminInfo> selectAll();

    Integer insert();
}