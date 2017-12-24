package com.ymy.service.impl;

import com.ymy.mapper.AreaMapper;
import com.ymy.model.AreaAreas;
import com.ymy.model.AreaCities;
import com.ymy.model.AreaProvinces;
import com.ymy.model.AreaStreets;
import com.ymy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<AreaProvinces> getProvinces() {
        return areaMapper.getProvinces();
    }

    @Override
    public List<AreaCities> getCities(Integer code) {
        return areaMapper.getCities(code);
    }

    @Override
    public List<AreaAreas> getAreas(Integer code) {
        return areaMapper.getAreas(code);
    }

    @Override
    public List<AreaStreets> getStreets(Integer code) {
        return areaMapper.getStreets(code);
    }
}
