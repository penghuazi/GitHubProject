package com.legend.dao;




import com.github.pagehelper.Page;
import com.legend.dao.domain.BasCity;

import java.util.List;

public interface BasCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasCity record);

    int insertSelective(BasCity record);

    BasCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasCity record);

    int updateByPrimaryKey(BasCity record);

    Page<?> selectByCondition();
}