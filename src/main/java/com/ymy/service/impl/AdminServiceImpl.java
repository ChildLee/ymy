package com.ymy.service.impl;

import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import com.ymy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAdmin() {
        return adminMapper.getAdmin();
    }
}
