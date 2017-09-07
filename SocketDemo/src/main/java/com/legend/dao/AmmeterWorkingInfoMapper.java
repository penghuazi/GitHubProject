package com.legend.dao;

import com.legend.dao.domain.AmmeterWorkingInfo;

public interface AmmeterWorkingInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterWorkingInfo record);

    int insertSelective(AmmeterWorkingInfo record);

    AmmeterWorkingInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmmeterWorkingInfo record);

    int updateByPrimaryKey(AmmeterWorkingInfo record);
}