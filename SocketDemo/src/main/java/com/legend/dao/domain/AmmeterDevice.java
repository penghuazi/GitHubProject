package com.legend.dao.domain;

import java.util.Date;

public class AmmeterDevice {
    private Integer id;

    private String imsi;

    private String address;

    private String meterNo;

    private String assManageCode;

    private String ratedVoltage;

    private String ratedCurrent;

    private String maxCurrent;

    private String activeAccLevel;

    private String reactiveAccLevel;

    private Integer activeConstant;

    private Integer reactiveConstant;

    private String type;

    private Date productDate;

    private String protocolNo;

    private String softwareNo;

    private String hardwareNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo == null ? null : meterNo.trim();
    }

    public String getAssManageCode() {
        return assManageCode;
    }

    public void setAssManageCode(String assManageCode) {
        this.assManageCode = assManageCode == null ? null : assManageCode.trim();
    }

    public String getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(String ratedVoltage) {
        this.ratedVoltage = ratedVoltage == null ? null : ratedVoltage.trim();
    }

    public String getRatedCurrent() {
        return ratedCurrent;
    }

    public void setRatedCurrent(String ratedCurrent) {
        this.ratedCurrent = ratedCurrent == null ? null : ratedCurrent.trim();
    }

    public String getMaxCurrent() {
        return maxCurrent;
    }

    public void setMaxCurrent(String maxCurrent) {
        this.maxCurrent = maxCurrent == null ? null : maxCurrent.trim();
    }

    public String getActiveAccLevel() {
        return activeAccLevel;
    }

    public void setActiveAccLevel(String activeAccLevel) {
        this.activeAccLevel = activeAccLevel == null ? null : activeAccLevel.trim();
    }

    public String getReactiveAccLevel() {
        return reactiveAccLevel;
    }

    public void setReactiveAccLevel(String reactiveAccLevel) {
        this.reactiveAccLevel = reactiveAccLevel == null ? null : reactiveAccLevel.trim();
    }

    public Integer getActiveConstant() {
        return activeConstant;
    }

    public void setActiveConstant(Integer activeConstant) {
        this.activeConstant = activeConstant;
    }

    public Integer getReactiveConstant() {
        return reactiveConstant;
    }

    public void setReactiveConstant(Integer reactiveConstant) {
        this.reactiveConstant = reactiveConstant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    public String getSoftwareNo() {
        return softwareNo;
    }

    public void setSoftwareNo(String softwareNo) {
        this.softwareNo = softwareNo == null ? null : softwareNo.trim();
    }

    public String getHardwareNo() {
        return hardwareNo;
    }

    public void setHardwareNo(String hardwareNo) {
        this.hardwareNo = hardwareNo == null ? null : hardwareNo.trim();
    }
}