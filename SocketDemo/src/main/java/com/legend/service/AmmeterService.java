package com.legend.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.legend.dao.AmmeterDeviceMapper;
import com.legend.dao.AmmeterWorkingInfoMapper;
import com.legend.dao.domain.AmmeterDevice;
import com.legend.dao.domain.AmmeterResult;
import com.legend.dao.domain.AmmeterWorkingInfo;
import com.legend.dao.domain.condition.AmmeterCondition;
import com.legend.socket.ClientProcess;
import com.legend.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by dell-pc on 2017/9/7.
 */

@Service
public class AmmeterService {

    @Value("${socket.port}")
    public static Integer SOCKET_PORT ;

    @Autowired
    private AmmeterWorkingInfoMapper ammeterWorkingInfoMapper;

    @Autowired
    private AmmeterDeviceMapper ammeterDeviceMapper;

    public Results updateAmmeterStatus(Integer status,Integer id){

        AmmeterWorkingInfo ammeterWorkingInfo = ammeterWorkingInfoMapper.selectByAmmeterId(id);
        if(ammeterWorkingInfo != null && ammeterWorkingInfo.getStatus() != 2 && ammeterWorkingInfo.getStatus() != 3){
        ammeterWorkingInfoMapper.updateByAmmeterId(id,2);
        AmmeterDevice ammeterDevice = ammeterDeviceMapper.selectByPrimaryKey(id);
        ammeterDevice.setSendStatus(status);
         new ClientProcess().new HandlerStatusThread(ammeterDevice,ammeterWorkingInfoMapper);
        }else{
            return Results.error("请等待，正在操作中。。。");
        }

        return Results.success(status == 1 ? "正在拉闸" :"正在合闸");
    }


    public Results list(AmmeterCondition ammeterCondition){
//        PageHelper.startPage(ammeterCondition.getPageIndex(),ammeterCondition.getPageSize());
         return Results.success(ammeterDeviceMapper.selectByCondition());
    }
}
