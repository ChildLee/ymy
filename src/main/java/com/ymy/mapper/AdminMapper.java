package com.ymy.mapper;

import com.ymy.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAdminAll();

    int updateAdmin(Admin admin);

    /**
     * 用户登录
     *
     * @return 用户信息
     */
    int login(Admin admin);
}