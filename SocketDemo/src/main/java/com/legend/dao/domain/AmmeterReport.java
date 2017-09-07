package com.legend.dao.domain;

import java.util.Date;

public class AmmeterReport {
    private Integer id;

    private Integer ammeterId;

    private String activeEnergy;

    private String reactiveEnergy;

    private Date sendTime;

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

    public String getActiveEnergy() {
        return activeEnergy;
    }

    public void setActiveEnergy(String activeEnergy) {
        this.activeEnergy = activeEnergy == null ? null : activeEnergy.trim();
    }

    public String getReactiveEnergy() {
        return reactiveEnergy;
    }

    public void setReactiveEnergy(String reactiveEnergy) {
        this.reactiveEnergy = reactiveEnergy == null ? null : reactiveEnergy.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}