package com.ymy.controller;

import com.ymy.model.AreaAreas;
import com.ymy.model.AreaCities;
import com.ymy.model.AreaProvinces;
import com.ymy.model.AreaStreets;
import com.ymy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaAction {

    @Autowired
    private AreaService areaService;

    @GetMapping("getProvinces")
    public List<AreaProvinces> getProvinces() {
        return areaService.getProvinces();
    }

    @GetMapping("getCities")
    public List<AreaCities> getCities(Integer code) {
        if (null == code) return null;
        return areaService.getCities(code);
    }

    @GetMapping("getAreas")
    public List<AreaAreas> getAreas(Integer code) {
        if (null == code) return null;
        return areaService.getAreas(code);
    }

    @GetMapping("getStreets")
    public List<AreaStreets> getStreets(Integer code) {
        if (null == code) return null;
        return areaService.getStreets(code);
    }
}
