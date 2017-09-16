package com.legend.controller;

import com.legend.dao.domain.AmmeterMonthlyReport;
import com.legend.dao.domain.AmmeterReport;
import com.legend.dao.domain.condition.AmmeterCondition;
import com.legend.dao.domain.condition.AmmeterUpdateCondition;
import com.legend.service.AmmeterReportServer;
import com.legend.service.AmmeterService;
import com.legend.utils.DateUtils;
import com.legend.utils.Results;
import com.legend.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell-pc on 2017/9/7.
 */

@RestController
@RequestMapping(value = "/ammeter/device")
public class AmmeterController {

    @Autowired
    private AmmeterService ammeterService;
    @Autowired
    private AmmeterReportServer reportServer;

    @PostMapping(value = "/updateStatus")
    @ApiOperation(value="电表开闸合闸操作")
    public Results updateAmmeterStatus(@RequestBody AmmeterUpdateCondition condition){
        return ammeterService.updateAmmeterStatus(condition.getStatus(),condition.getId());
    }

    @PostMapping(value = "/list")
    @ApiOperation(value="电表信息列表")
    public Results list(@RequestBody AmmeterCondition ammeterCondition ){
        ammeterCondition.setPageIndex(ammeterCondition.getPageIndex());
        ammeterCondition.setPageSize(ammeterCondition.getPageSize());
        return ammeterService.listAmmeterInfo(ammeterCondition);
    }
    @GetMapping(value = "/dailyReport/{ammeterId}/{reportDate}")
    @ApiOperation(value = "根据时间获取用电量报表",notes = "Legend")
    public Results dailyReport(@RequestParam("ammeterId") Integer ammeterId,@RequestParam("reportDate") String reportDate){
        Results result = null;
        if(reportDate.length() == 10) {
            if(DateUtils.stringToDate(reportDate) == null){
                 return  Results.error("时间有误!");
            }
            List<AmmeterReport> dailyReport = reportServer.listDailyReport(reportDate, ammeterId);
            Map<String, Object> dailyMap = StringUtils.initDailyReportMap();
            if (dailyReport != null) {
                for (AmmeterReport report : dailyReport) {
                    dailyMap.put(String.valueOf(report.getHour()), report);
                }
            }
            result = Results.success(dailyMap);
        }else if(reportDate.length() == 7){
            if(DateUtils.stringYearMonthToDate(reportDate) == null){
                return  Results.error("时间有误!");
            }
            Integer month = Integer.parseInt(reportDate.substring(reportDate.indexOf("-")+1));
            List<AmmeterMonthlyReport> monthlyReports = reportServer.listMonthReport(reportDate,ammeterId);
            Map<String, Object> monthMap = StringUtils.initMonthReportMap(month);
            if(monthlyReports != null) {
                for (AmmeterMonthlyReport monthlyReport : monthlyReports) {
                    monthMap.put(String.valueOf(monthlyReport.getDay()),monthlyReport);
                }
            }
            result = Results.success(monthMap);

        }
        return result == null ? Results.error("获取数据异常!"):result;
    }

    public static void main(String[] args) {
        String str ="2017-09";
        System.out.println(str.substring(0,str.indexOf("-")));
    }

}
