package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.District;
import com.shop.mapper.DistrictMapper;
import com.shop.service.DistrictService;

/**
* @Author:Antony
* @CreateDate:Feb 24, 2023
*/
@Service
public class DistrictServiceImpl implements DistrictService{
	
	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> getDistrictByParent(String parent) {
		
		List<District> list = districtMapper.findByParent(parent);
		
		/**
		 * 在对数据进行网络传输时，为了提升传输效率，节省网络资源开销，可以将无关紧要的数据设置为null
		 */
		for(District d: list) {
			d.setId(null);
			d.setParent(null);
		}
		return list;
	}

	@Override
	public String getNameByCode(String code) {
		// TODO Auto-generated method stub
		return districtMapper.findNameByCode(code);
	}
	

}
