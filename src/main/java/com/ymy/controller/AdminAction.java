package com.ymy.controller;

import com.ymy.entity.Admin;
import com.ymy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin")
    public Admin getAdmin() {
        return adminService.getAdmin();
    }
}
