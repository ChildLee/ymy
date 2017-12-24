package com.ymy.service;

import com.ymy.model.AreaAreas;
import com.ymy.model.AreaCities;
import com.ymy.model.AreaProvinces;
import com.ymy.model.AreaStreets;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

public interface AreaService {
    /**
     * @return 查询所有省份
     */
    List<AreaProvinces> getProvinces();

    /**
     * @return 根据省级行政区划代码查询对应城市
     */
    List<AreaCities> getCities(Integer code);

    /**
     * @return 根据市级行政区划代码查询对应区/县和邮编
     */
    @Results({
            @Result(property = "zipCode", column = "zip_code")
    })
    List<AreaAreas> getAreas(Integer code);

    /**
     * @return 根据区/县行政区划代码查询对应镇/乡
     */
    List<AreaStreets> getStreets(Integer code);
}
