package com.legend.dao;

import com.legend.dao.domain.AmmeterMonthlyReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmmeterMonthlyReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmmeterMonthlyReport record);

    int insertSelective(AmmeterMonthlyReport record);

    AmmeterMonthlyReport selectByPrimaryKey(Integer id);

    List<AmmeterMonthlyReport> queryByParams(AmmeterMonthlyReport record);

    int updateByPrimaryKeySelective(AmmeterMonthlyReport record);

    int updateByPrimaryKey(AmmeterMonthlyReport record);
}