package com.ymy.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 封装返回的结果对象
 *
 * @param <T> 包装的数据
 */
@ApiModel
public class Result<T> {

    /**
     * 返回错误码
     */
    @ApiModelProperty("错误码")
    private Integer code;

    /**
     * 返回提示信息
     */
    @ApiModelProperty("提示信息")
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
