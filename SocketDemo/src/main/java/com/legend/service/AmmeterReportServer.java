package com.legend.service;

import com.legend.dao.AmmeterMonthlyReportMapper;
import com.legend.dao.AmmeterReportMapper;
import com.legend.dao.domain.AmmeterMonthlyReport;
import com.legend.dao.domain.AmmeterReport;
import com.legend.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell-pc on 2017/9/16.
 */
@Service
public class AmmeterReportServer {

    @Autowired
    private AmmeterMonthlyReportMapper monthlyReportMapper;

    @Autowired
    private AmmeterReportMapper reportMapper;


    @Autowired
    private SysDictionaryService sysDictionaryService;


    public String sendReponseParamsForReport(AmmeterReport report){
        String reponseStr ="-1";
        report.setDateTime(DateUtils.getCurrentDate());
        report.setHour(DateUtils.getHour()-1);
        AmmeterReport reportDB = reportMapper.queryByParams(report);
        if(reportDB != null){
               //当前正向总功率
                reponseStr =sysDictionaryService.getDynamicValue(11);
        }
        return reponseStr;
    }

    public List<AmmeterReport> listDailyReport(String reportDate,Integer ammeterId){
        AmmeterReport report = new AmmeterReport();
        report.setDateTime(reportDate);
        report.setAmmeterId(ammeterId);
        return  reportMapper.dailyReportByParams(report);
    }

    public List<AmmeterMonthlyReport> listMonthReport(String time,Integer ammeterId){
        AmmeterMonthlyReport monthlyReport = new AmmeterMonthlyReport();
        monthlyReport.setAmmeterId(ammeterId);
        monthlyReport.setTime(time);
        return monthlyReportMapper.queryByParams(monthlyReport);
    }
}
