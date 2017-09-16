package com.legend.dao;

import com.legend.dao.domain.AmmeterReport;

import java.util.List;

public interface AmmeterReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterReport record);

    int insertSelective(AmmeterReport record);

    AmmeterReport selectByPrimaryKey(Integer id);

    AmmeterReport queryByParams(AmmeterReport record);

    List<AmmeterReport> dailyReportByParams(AmmeterReport record);

    int updateByPrimaryKeySelective(AmmeterReport record);

    int updateByPrimaryKey(AmmeterReport record);
}