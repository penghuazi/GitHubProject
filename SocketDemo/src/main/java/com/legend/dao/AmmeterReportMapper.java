package com.legend.dao;

import com.legend.dao.domain.AmmeterReport;

public interface AmmeterReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterReport record);

    int insertSelective(AmmeterReport record);

    AmmeterReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmmeterReport record);

    int updateByPrimaryKey(AmmeterReport record);
}