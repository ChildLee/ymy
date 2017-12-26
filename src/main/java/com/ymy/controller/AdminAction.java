package com.ymy.controller;

import com.ymy.service.AdminService;
import com.ymy.util.Result;
import com.ymy.util.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "标签", description = "描述")
@RestController
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "说明方法的用途、作用", notes = "方法的备注说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path", dataType = "boolean"),
            @ApiImplicitParam(name = "name", value = "参数说明、解释", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("admin")
    public Result getAdmin(Integer id, String name) {
        return ResultUtil.success(adminService.getAdmin());
    }
}
