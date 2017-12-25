package com.ymy.mapper;

import com.ymy.model.AreaAreas;
import com.ymy.model.AreaCities;
import com.ymy.model.AreaProvinces;
import com.ymy.model.AreaStreets;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {
    /**
     * @return 查询所有省份
     */
    @Select("select * from area_provinces")
    List<AreaProvinces> getProvinces();

    /**
     * @return 根据省级行政区划代码查询对应城市
     */
    @Select("select * from area_cities where parent_code=#{code}")
    @Results({
            @Result(property = "parentCode", column = "parent_code")
    })
    List<AreaCities> getCities(Integer code);

    /**
     * @return 根据市级行政区划代码查询对应区/县和邮编
     */
    @Select("select * from area_areas where parent_code=#{code}")
    @Results({
            @Result(property = "zipCode", column = "zip_code"),
            @Result(property = "areaCode", column = "area_code"),
            @Result(property = "parentCode", column = "parent_code")
    })
    List<AreaAreas> getAreas(Integer code);

    /**
     * @return 根据区/县行政区划代码查询对应镇/乡
     */
    @Select("select * from area_streets where parent_code=#{code}")
    @Results({
            @Result(property = "parentCode", column = "parent_code")
    })
    List<AreaStreets> getStreets(Integer code);
}