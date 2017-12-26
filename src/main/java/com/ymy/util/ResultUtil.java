package com.ymy.util;

/**
 * 返回结果对象工具类
 */
public class ResultUtil {
    /**
     * @param object 需要返回的结果对象
     * @return 成功后的结果
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * @param code 状态码
     * @param msg  提示信息
     * @return 失败后的结果
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
