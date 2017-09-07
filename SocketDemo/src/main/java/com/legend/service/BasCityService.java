package com.legend.service;

import com.legend.dao.BasCityMapper;
import com.legend.dao.domain.BasCity;
import com.legend.page.Page;
import com.legend.page.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*  Created by Jianhua on 2017-08-24 15:56:23.
*/
@Service
public class BasCityService {
    @Autowired
    private BasCityMapper basCityMapper;


    public Page<?> list(BasCity basCity) {
        PageHelper.startPage(2,15);
        Page<?> list = basCityMapper.selectByCondition();

//        BeanUtils.copyProperties(list2,list);
        return list;
    }

    public BasCity get(Integer id) {
        return null;
    }

    public int insert(BasCity basCity) {
        return 0;
    }

    public int update(BasCity basCity) {
        return 0;
    }

    public int delete(Integer id) {
        return 0;
    }

}
