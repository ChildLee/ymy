package com.ymy.controller;

import com.ymy.service.AreaService;
import com.ymy.util.Result;
import com.ymy.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "收货地址", description = "省市/区县镇四级联动")
@RestController
public class AreaAction {

    @Autowired
    private AreaService areaService;

    @ApiOperation(value = "查询所有省份", notes = "添加收货地址时,请先调用该接口")
    @GetMapping("getProvinces")
    public Result getProvinces() {
        return ResultUtil.success(areaService.getProvinces());
    }

    @ApiOperation(value = "根据省级行政区划代码查询所有市/区", notes = "先查询所有省份")
    @ApiImplicitParam(name = "code", value = "省级行政区划代码", required = true, paramType = "query", dataType = "int")
    @GetMapping("getCities")
    public Result getCities(Integer code) {
        if (null == code) return ResultUtil.error(1001);
        if (code.toString().length() != 2) return ResultUtil.error(1002);
        return ResultUtil.success(areaService.getCities(code));
    }

    @ApiOperation(value = "根据市/区行政区划代码查询所有县", notes = "先查询所有市/区")
    @ApiImplicitParam(name = "code", value = "市级行政区划代码", required = true, paramType = "query", dataType = "int")
    @GetMapping("getAreas")
    public Result getAreas(Integer code) {
        if (null == code) return ResultUtil.error(1001);
        if (code.toString().length() != 4) return ResultUtil.error(1002);
        return ResultUtil.success(areaService.getAreas(code));
    }

    @ApiOperation(value = "根据县行政区划代码查询所有镇", notes = "先查询所有县")
    @ApiImplicitParam(name = "code", value = "县级行政区划代码", required = true, paramType = "query", dataType = "int")
    @GetMapping("getStreets")
    public Result getStreets(Integer code) {
        if (null == code) return ResultUtil.error(1001);
        if (code.toString().length() != 6) return ResultUtil.error(1002);
        return ResultUtil.success(areaService.getStreets(code));
    }
}
