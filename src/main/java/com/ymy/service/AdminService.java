package com.ymy.service;

import com.ymy.model.Admin;

import java.util.List;

public interface AdminService {

    int updateAdmin(Admin record);

    List<Admin> selectAdminAll();
}
