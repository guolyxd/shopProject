package com.shop.service;

import java.util.List;

import com.shop.entity.District;

/**
* @Author:Antony
* @CreateDate:Feb 24, 2023
*/

public interface DistrictService {
	
	List<District> getDistrictByParent(String parent);
	String getNameByCode(String code);

}
