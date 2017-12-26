package com.ymy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AreaAreas {
    @ApiModelProperty("县行政区划代码")
    private Integer code;

    @ApiModelProperty("县名")
    private String name;

    @ApiModelProperty("邮编")
    private Integer zipCode;

    @ApiModelProperty("区号")
    private Integer areaCode;

    @ApiModelProperty("市/区行政区划代码")
    private Integer parentCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", parentCode=").append(parentCode);
        sb.append("]");
        return sb.toString();
    }
}