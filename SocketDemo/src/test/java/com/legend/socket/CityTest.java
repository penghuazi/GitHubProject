package com.legend.socket;

import com.alibaba.fastjson.JSONObject;
import com.legend.Application;
import com.legend.dao.AmmeterDeviceMapper;
import com.legend.dao.BasCityMapper;
import com.legend.service.BasCityService;
import com.legend.service.SysDictionaryService;
import com.legend.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by dell-pc on 2017/8/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CityTest {

    @Autowired
    public BasCityMapper basCityMapper;

    @Autowired
    public BasCityService basCityService;

    @Autowired
    private AmmeterDeviceMapper ammeterDeviceMapper;

    @Test
    public void getCityId(){

        System.out.println(SysDictionaryService.getStaticValue(1));

        String json = JSONObject.toJSONString( ammeterDeviceMapper.selectByPrimaryKey(1));
        System.out.println("******************************socket start***********************************");

        System.out.println("测试结果--------->" + json);

        System.out.println("******************************socket end*************************************");
    }

}
