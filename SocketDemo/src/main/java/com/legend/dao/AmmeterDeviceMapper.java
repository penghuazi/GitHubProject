package com.legend.dao;

import com.github.pagehelper.Page;
import com.legend.dao.domain.AmmeterDevice;
import com.legend.dao.domain.AmmeterInfoResult;
import com.legend.dao.domain.AmmeterResult;
import com.legend.dao.domain.condition.AmmeterCondition;

public interface AmmeterDeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterDevice record);

    int insertSelective(AmmeterDevice record);

    AmmeterDevice selectByPrimaryKey(Integer id);

    AmmeterDevice selectByImsiKey(String imsi);

    Page<AmmeterInfoResult> selectAmmeterInfo(AmmeterCondition condition);

    int updateByPrimaryKeySelective(AmmeterDevice record);

    int updateByImsiKeySelective(AmmeterDevice record);

    int updateByPrimaryKey(AmmeterDevice record);

    Page<AmmeterResult> selectByCondition();
}