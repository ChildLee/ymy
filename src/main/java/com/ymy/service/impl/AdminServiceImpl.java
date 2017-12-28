package com.ymy.service.impl;

import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import com.ymy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin selectAdmin(Integer id) {
        return adminMapper.selectAdmin(id);
    }

    @Override
    public List<Admin> selectAdminAll() {
        return adminMapper.selectAdminAll();
    }

    @Override
    public Integer login(Admin admin) {
        return adminMapper.login(admin);
    }

    @Override
    public String selectToken(Integer id) {
        return adminMapper.selectToken(id);
    }
}
