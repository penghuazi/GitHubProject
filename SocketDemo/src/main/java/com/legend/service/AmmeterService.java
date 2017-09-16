package com.legend.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.legend.dao.AmmeterDeviceMapper;
import com.legend.dao.AmmeterWorkingInfoMapper;
import com.legend.dao.domain.*;
import com.legend.dao.domain.condition.AmmeterCondition;
import com.legend.utils.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell-pc on 2017/9/7.
 */

@Service
public class AmmeterService {
    private final static Logger logger = LoggerFactory.getLogger(AmmeterService.class);
    @Value("${socket.port}")
    public static Integer SOCKET_PORT ;

    @Autowired
    private AmmeterWorkingInfoMapper ammeterWorkingInfoMapper;

    @Autowired
    private AmmeterDeviceMapper ammeterDeviceMapper;
    @Autowired
    private SysDictionaryService sysDictionaryService;

    public Results updateAmmeterStatus(Integer status,Integer id){

        AmmeterWorkingInfo ammeterWorkingInfo = ammeterWorkingInfoMapper.selectByAmmeterId(id);
        if(ammeterWorkingInfo != null && (ammeterWorkingInfo.getStatus() == null ||
                (ammeterWorkingInfo.getStatus() != 2 && ammeterWorkingInfo.getStatus() != 3)
               )){
            ammeterWorkingInfoMapper.updateByAmmeterId(id,status+2);
//        AmmeterDevice ammeterDevice = ammeterDeviceMapper.selectByPrimaryKey(id);
//        new ClientProcess().new HandlerStatusThread(ammeterDevice,ammeterWorkingInfoMapper);
        }else{
            return Results.error("请等待，正在操作中。。。");
        }

        return Results.success(status == 1 ? "正在拉闸" :"正在合闸");
    }


    public Results list(AmmeterCondition ammeterCondition){
        PageHelper.startPage(ammeterCondition.getPageIndex(),ammeterCondition.getPageSize());
         return Results.success(ammeterDeviceMapper.selectByCondition());
    }

    public Results listAmmeterInfo(AmmeterCondition ammeterCondition){
        PageHelper.startPage(ammeterCondition.getPageIndex(),ammeterCondition.getPageSize());
        Page<AmmeterInfoResult> resultPage = ammeterDeviceMapper.selectAmmeterInfo(ammeterCondition);
        Results results = new Results(resultPage);
        if(resultPage != null)
        results.setTotal(resultPage.getTotal());
        return results;
    }

    public  String getSocketRequestParam(AmmeterDevice ammeterDevice,
                                               AmmeterWorkingInfo ammeterWorkingInfo,
                                        boolean firstResponse){
        if(firstResponse) {
            ammeterDevice.setImsi(ammeterDevice.getInputMsg().substring(5));
            AmmeterDevice device = ammeterDeviceMapper.selectByImsiKey(ammeterDevice.getImsi());
            if(device != null){
                int deviceIndex = ammeterDevice.returnParamIndex(device);
                if(deviceIndex != -1){
                    return sysDictionaryService.getDynamicValue(deviceIndex);
                }else{
                    AmmeterWorkingInfo info = ammeterWorkingInfoMapper.selectByAmmeterId(device.getId());
                    if(info != null) {
                        int workInfoIndex = info.returnWorkInfoIndex(info);
                        if(workInfoIndex == 29 &&(info.getStatus() ==2 || info.getStatus() ==3)){
                            ammeterWorkingInfoMapper.updateByAmmeterId(info.getAmmeterId(),info.getStatus()-2);
                            return sysDictionaryService.getDynamicValue(workInfoIndex) +
                                    ((info.getStatus() == 2 )  ? "ab8967454d":"ab8967454e");
                        }
                        return sysDictionaryService.getDynamicValue(workInfoIndex);
                    }else {
                        return sysDictionaryService.getDynamicValue(1);
                    }
                }
            }else{
                ammeterDeviceMapper.insert(ammeterDevice);
                return sysDictionaryService.getDynamicValue(13);
            }
        }else{
            int deviceIndex = ammeterDevice.returnParamIndex(ammeterDevice);
            if(deviceIndex != -1){
                return sysDictionaryService.getDynamicValue(deviceIndex);
            }else{
                int infoIndex = ammeterWorkingInfo.returnWorkInfoIndex(ammeterWorkingInfo);
                if(infoIndex == 29 &&(ammeterWorkingInfo.getStatus() ==2 || ammeterWorkingInfo.getStatus() ==3)){
                    ammeterWorkingInfoMapper.updateByAmmeterId(ammeterWorkingInfo.getAmmeterId(),ammeterWorkingInfo.getStatus()-2);
                    return sysDictionaryService.getDynamicValue(infoIndex) +
                            ((ammeterWorkingInfo.getStatus() == 0 )  ? "ab8967454d":"ab8967454e");
                }
                if(infoIndex != -1)
                return sysDictionaryService.getDynamicValue(infoIndex);
            }
        }
        return "-1";
    }

    @Transactional
    public String updateAmmeterDevice(AmmeterDevice ammeterDevice) {
        String response ="-1";
        SysDictionaryService sysService = new SysDictionaryService();
        List<SysDictionary> list = sysService.getDictionartLists();
        if(ammeterDevice != null && ammeterDevice.getInputMsg()!= null && ammeterDevice.getInputMsg().startsWith("imsi:")){
            response = getSocketRequestParam(ammeterDevice,null,true);
        }else if(ammeterDevice == null || ammeterDevice.getInputMsg() == null){
            return response;
        }
        if(list != null) {
            for (int i = 1; i <= list.size(); i++) {
                logger.info("dictionary :"+i+": "+sysService.getDynamicValue(i));
                if (ammeterDevice.getInputMsg().contains(sysService.getDynamicValue(i))) {
                    String params = ammeterDevice.getInputMsg().substring(
                            ammeterDevice.getInputMsg().indexOf("+")+1, ammeterDevice.getInputMsg().length());
                    String result = params.substring(sysService.getDynamicValue(i).length()+1,
                            params.length());
                    //截取Imsi
                    ammeterDevice.setImsi(ammeterDevice.getInputMsg().substring(0, ammeterDevice.getInputMsg().indexOf("+")));
                    AmmeterDevice device = ammeterDeviceMapper.selectByImsiKey(ammeterDevice.getImsi());
                    //set 参数
                    if(i > 12) {
                        //更新电表固有参数
                        ammeterDevice.setParams(result, i, ammeterDevice);
                        if (device != null) {
                            //更新电表固有信息表
                            ammeterDeviceMapper.updateByImsiKeySelective(ammeterDevice);
                        } else {
                            //插入电表固有信息表
                            ammeterDeviceMapper.insert(ammeterDevice);
                        }
                        response =getSocketRequestParam(ammeterDevice,ammeterWorkingInfoMapper.selectByAmmeterId(ammeterDevice.getId()),false);
                    }else{
                        //更新电表工作参数
                        AmmeterWorkingInfo ammeterWorkingInfo = new AmmeterWorkingInfo();
                        ammeterWorkingInfo.setParams(result,i,ammeterWorkingInfo);
                        if (device != null) {
                            ammeterWorkingInfo.setAmmeterId(device.getId());
                            AmmeterWorkingInfo info = ammeterWorkingInfoMapper.selectByAmmeterId(device.getId());
                            if(info != null){
                                ammeterWorkingInfoMapper.updateByAmmeterIdSelective(ammeterWorkingInfo);
                            }else{
                                ammeterWorkingInfo.setAmmeterId(device.getId());
                                ammeterWorkingInfoMapper.insert(ammeterWorkingInfo);
                            }
                            response =getSocketRequestParam(device,info,false);
                        }else{
                            //插入固有信息 和工作状态参数表
                            ammeterDeviceMapper.insert(ammeterDevice);
                            ammeterWorkingInfo.setAmmeterId(ammeterDevice.getId());
                            ammeterWorkingInfoMapper.insert(ammeterWorkingInfo);
                            response =getSocketRequestParam(ammeterDevice,ammeterWorkingInfo,false);

                        }

                    }

                    break;
                }
            }
            return response;
        }else{
            return "-1";
        }
    }


    public static void main(String[] args) {
        String str ="460001357924680+0x2800001+120.223";
        System.out.println(str.substring(0,str.indexOf("+")));
    }
}
