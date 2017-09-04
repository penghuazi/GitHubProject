package com.legend.test;

import com.alibaba.fastjson.JSONObject;
import com.legend.Application;
import com.legend.dao.BasCityMapper;
import com.legend.service.BasCityService;
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
    @Test
    public void getCityId(){

        String json = JSONObject.toJSONString( basCityService.list(null));
        System.out.println("******************************test start***********************************");

        System.out.println("测试结果--------->" + json);

        System.out.println("******************************test end*************************************");
    }

}
