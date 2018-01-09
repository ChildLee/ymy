package com.ymy.controller;

import com.github.pagehelper.PageHelper;
import com.ymy.model.Admin;
import com.ymy.service.AdminService;
import com.ymy.util.Result;
import com.ymy.util.ResultUtil;
import com.ymy.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "管理员", description = "对管理员进行增删改查修改等操作")
@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @PostMapping("addAdmin")
    public int addAdmin(Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("deleteAdmin")
    public int deleteAdmin(Integer id) {
        return adminService.deleteAdmin(id);
    }

    @ApiOperation(value = "修改管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员ID", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "level", value = "管理员级别", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "管理员账号状态", paramType = "query", dataType = "int"),
    })
    @PostMapping("updateAdmin")
    public Result updateAdmin(Admin admin) {
        System.out.println(admin);
        return ResultUtil.success(adminService.updateAdmin(admin));
    }

    @GetMapping("selectAdmin")
    public Admin selectAdmin(Integer id) {
        return adminService.selectAdmin(id);
    }

    @GetMapping("selectAdminAll")
    public Result selectAdminAll() {
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(1, 2);
        //紧跟着的第一个select方法会被分页
        List<Admin> list = adminService.selectAdminAll();
        return ResultUtil.success(list);
    }

    @PostMapping("login")
    public Result login(String username, String password) {
        if (Util.paramIsNull(username) || Util.paramIsNull(password)) return ResultUtil.error(1001);
        Admin admin = new Admin();
        admin.setUsername(username.trim());
        admin.setPassword(password.trim());
        return ResultUtil.success(adminService.login(admin));
    }

    @GetMapping("selectToken")
    public String selectToken(Integer id) {
        return adminService.selectToken(id);
    }
}