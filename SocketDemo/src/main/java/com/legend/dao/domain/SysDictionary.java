package com.legend.dao.domain;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/9/4.
 */
public class SysDictionary implements Serializable {

    private int id ;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private int type;
    private int paramId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParamId() {
        return paramId;
    }

    public void setParamId(int paramId) {
        this.paramId = paramId;
    }
}
