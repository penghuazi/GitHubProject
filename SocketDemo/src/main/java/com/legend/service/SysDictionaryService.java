/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.legend.service;

import com.legend.dao.SysDictionaryMapper;
import com.legend.dao.domain.SysDictionary;
import com.legend.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The base service for SysDictionary
 * @author dell
 * @Time 2017-04-12 16:24:53
 */
@Service
public class SysDictionaryService {
	
    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

	private static List<SysDictionary> dictionaryList = new ArrayList<>();

	@Autowired
	public List<SysDictionary> getDictionartLists() {
		try {
			if (dictionaryList == null || dictionaryList.size() == 0) {
				dictionaryList = sysDictionaryMapper.selectByCondition();
			}
			System.out.println("数据字典 加载成功 。。。。");
		} catch (Exception e) {
		}
		return dictionaryList;
	}
	//获取静态的,数据只能通过重启服务器才能有,效率高
	public static String getStaticValue(Integer paramId) {
		String result = null;
		for (SysDictionary dictionary : dictionaryList) {
			if (paramId.intValue() == dictionary.getParamId()) {
				result = dictionary.getParam1()+
						dictionary.getParam2()+
						dictionary.getParam3()+
						dictionary.getParam4();
				return result;
			}
		}
		return result;
	}

	//先从静态中获取,如果没有再查询一遍
	public String getDynamicValue(Integer paramId) {
		try {
			String value = getStaticValue(paramId);
			if (value != null) {
				return value;
			}
			if(dictionaryList != null){
				return "";
			}
			dictionaryList = sysDictionaryMapper.selectByCondition();
			String result = null;
			for (SysDictionary dictionary : dictionaryList) {
				if (paramId.intValue() == dictionary.getParamId()) {
					result = dictionary.getParam1()+
							dictionary.getParam2()+
							dictionary.getParam3()+
							dictionary.getParam4();
					return result;
				}
			}
		} catch (Exception e) {

		}
		return "";
	}
	public List<SysDictionary> getDictionary(){
		return sysDictionaryMapper.selectByCondition();
	}
}
