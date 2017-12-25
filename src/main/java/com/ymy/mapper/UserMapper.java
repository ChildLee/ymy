package com.ymy.mapper;

import com.ymy.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}