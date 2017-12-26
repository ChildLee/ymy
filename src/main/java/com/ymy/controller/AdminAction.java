package com.ymy.controller;

import com.ymy.service.AdminService;
import com.ymy.util.Result;
import com.ymy.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin")
    public Result getAdmin(Integer id, String name) {
        return ResultUtil.success(adminService.getAdmin());
    }
}
