package com.ymy.mapper;

import com.ymy.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    Integer insert(Admin admin);

    List<Admin> selectAll();
}