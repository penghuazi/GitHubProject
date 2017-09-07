package com.legend.dao;

import com.legend.dao.domain.AmmeterDevice;

public interface AmmeterDeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterDevice record);

    int insertSelective(AmmeterDevice record);

    AmmeterDevice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmmeterDevice record);

    int updateByPrimaryKey(AmmeterDevice record);
}