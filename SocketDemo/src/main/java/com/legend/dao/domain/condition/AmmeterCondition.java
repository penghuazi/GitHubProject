package com.legend.dao.domain.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/9/7.
 */
@ApiModel(value = "终端查询")
public class AmmeterCondition implements Serializable{

    @ApiModelProperty(value = "当前页")
    private Integer pageIndex =1;
    @ApiModelProperty(value = "页码显示的数")
    private Integer pageSize =10;
    @ApiModelProperty(value = "表号")
    private String meterNo;
    @ApiModelProperty(value = "终端唯一号")
    private String imsi;
    @ApiModelProperty(value = "通讯地址")
    private String address;

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
