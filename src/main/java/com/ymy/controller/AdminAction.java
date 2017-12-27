package com.ymy.controller;

import com.ymy.model.Admin;
import com.ymy.service.AdminService;
import com.ymy.util.Result;
import com.ymy.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理员", description = "对管理员进行增删改查修改等操作")
@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @GetMapping("selectAdminAll")
    public Result selectAdminAll() {
        return ResultUtil.success(adminService.selectAdminAll());
    }

    @ApiOperation(value = "修改管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员ID", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "level", value = "管理员级别", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "lastLoginTime", value = "最后登录时间", paramType = "query", dataType = "date"),
            @ApiImplicitParam(name = "status", value = "管理员账号状态", paramType = "query", dataType = "int", defaultValue = "1"),
    })
    @PostMapping("updateAdmin")
    public Result updateAdmin(Admin admin) {
        System.out.println(admin);
        return ResultUtil.success(adminService.updateAdmin(admin));
    }
}