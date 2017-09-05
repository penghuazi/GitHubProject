package com.legend.dao;


import com.legend.dao.domain.SysDictionary;

import java.util.List;

/**
 * Created by dell-pc on 2017/9/4.
 */
public interface SysDictionaryMapper {

        List<SysDictionary> selectByCondition();

}
