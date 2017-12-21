package com.ymy.service.impl;

import com.ymy.entity.Admin;
import com.ymy.mapper.AdminMapper;
import com.ymy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdmin() {
        return adminMapper.getAdmin();
    }
}
