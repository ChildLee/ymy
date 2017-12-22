package com.ymy.mapperTwo;

import com.ymy.entity.province;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    @Select("select * from provinces")
    List<province> getProvinces();
}
