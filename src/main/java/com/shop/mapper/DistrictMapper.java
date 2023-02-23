package com.shop.mapper;

import java.util.List;

import com.shop.entity.District;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface DistrictMapper {

	List<District> findByParent(Integer parent);
}
