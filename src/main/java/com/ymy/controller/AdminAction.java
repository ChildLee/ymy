package com.ymy.controller;

import com.ymy.model.Admin;
import com.ymy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin")
    public List<Admin> getAdmin() {
        return adminService.getAdmin();
    }
}
