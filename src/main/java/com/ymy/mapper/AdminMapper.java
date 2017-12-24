package com.ymy.mapper;

import com.ymy.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    List<Admin> selectAll();
}