package com.legend.dao.domain;

public class AmmeterWorkingInfo {
    private Integer id;

    private Integer ammeterId;

    private String zeroLineCurrent;

    private String gridFrequency;

    private String averagePowerMinute;

    private String activeDemand;

    private String reactiveDemand;

    private String apparentDemand;

    private String temperature;

    private String clockCellVoltage;

    private String noPowerCellVoltage;

    private String batteryWorkingTime;

    private String activePower;

    private String reverseActivePower;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmmeterId() {
        return ammeterId;
    }

    public void setAmmeterId(Integer ammeterId) {
        this.ammeterId = ammeterId;
    }

    public String getZeroLineCurrent() {
        return zeroLineCurrent;
    }

    public void setZeroLineCurrent(String zeroLineCurrent) {
        this.zeroLineCurrent = zeroLineCurrent == null ? null : zeroLineCurrent.trim();
    }

    public String getGridFrequency() {
        return gridFrequency;
    }

    public void setGridFrequency(String gridFrequency) {
        this.gridFrequency = gridFrequency == null ? null : gridFrequency.trim();
    }

    public String getAveragePowerMinute() {
        return averagePowerMinute;
    }

    public void setAveragePowerMinute(String averagePowerMinute) {
        this.averagePowerMinute = averagePowerMinute == null ? null : averagePowerMinute.trim();
    }

    public String getActiveDemand() {
        return activeDemand;
    }

    public void setActiveDemand(String activeDemand) {
        this.activeDemand = activeDemand == null ? null : activeDemand.trim();
    }

    public String getReactiveDemand() {
        return reactiveDemand;
    }

    public void setReactiveDemand(String reactiveDemand) {
        this.reactiveDemand = reactiveDemand == null ? null : reactiveDemand.trim();
    }

    public String getApparentDemand() {
        return apparentDemand;
    }

    public void setApparentDemand(String apparentDemand) {
        this.apparentDemand = apparentDemand == null ? null : apparentDemand.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getClockCellVoltage() {
        return clockCellVoltage;
    }

    public void setClockCellVoltage(String clockCellVoltage) {
        this.clockCellVoltage = clockCellVoltage == null ? null : clockCellVoltage.trim();
    }

    public String getNoPowerCellVoltage() {
        return noPowerCellVoltage;
    }

    public void setNoPowerCellVoltage(String noPowerCellVoltage) {
        this.noPowerCellVoltage = noPowerCellVoltage == null ? null : noPowerCellVoltage.trim();
    }

    public String getBatteryWorkingTime() {
        return batteryWorkingTime;
    }

    public void setBatteryWorkingTime(String batteryWorkingTime) {
        this.batteryWorkingTime = batteryWorkingTime == null ? null : batteryWorkingTime.trim();
    }

    public String getActivePower() {
        return activePower;
    }

    public void setActivePower(String activePower) {
        this.activePower = activePower == null ? null : activePower.trim();
    }

    public String getReverseActivePower() {
        return reverseActivePower;
    }

    public void setReverseActivePower(String reverseActivePower) {
        this.reverseActivePower = reverseActivePower == null ? null : reverseActivePower.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}