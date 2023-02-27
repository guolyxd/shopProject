package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shop.entity.Address;
import com.shop.mapper.AddressMapper;
import com.shop.mapper.DistrictMapper;
import com.shop.service.AddressService;
import com.shop.service.exception.AccessDeniedException;
import com.shop.service.exception.AddressCountLimitException;
import com.shop.service.exception.AddressNotFoundException;
import com.shop.service.exception.InsertException;
import com.shop.service.exception.UpdateException;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private DistrictMapper districtMapper;
	
	@Value("${user.address.max-count}")
	private Integer maxCount;

	@Override
	public void addNewAddress(Integer uid, String username, Address address) {
		
		Integer count =addressMapper.countByUid(uid);
		if(count >= maxCount) {
			throw new AddressCountLimitException("Exceed the max limite !");
		}
		
		String provinceName=districtMapper.findNameByCode(address.getProvinceCode());
		String cityName=districtMapper.findNameByCode(address.getCityCode());
		String areaName=districtMapper.findNameByCode(address.getAreaCode());
		
		address.setProvinceName(provinceName);
		address.setCityName(cityName);
		address.setAreaName(areaName);
		address.setUid(uid);
		Integer isDefault = count ==0? 1:0;
		address.setIsDefault(isDefault);
		address.setCreatedTime(new Date());
		address.setCreatedUser(username);
		address.setModifiedTime(new Date());
		address.setModifiedUser(username);
		
		Integer row = addressMapper.insert(address);
		
		if(!row.equals(1)) {
			throw new InsertException("Insert exception !");
		}
		
		
	}

	@Override
	public List<Address> getByUid(Integer uid) {
		
		List<Address> list = addressMapper.findByUid(uid);
		for(Address address : list) {
			address.setAreaCode(null);
			address.setProvinceCode(null);
			address.setCityCode(null);
			address.setCreatedTime(null);
			address.setCreatedUser(null);
			address.setModifiedTime(null);
			address.setModifiedUser(null);
			address.setIsDefault(null);
		}
		return list;
	}

	@Override
	public void updateDefaultAddress(Integer aid, Integer uid, String username) {
		
		Address result = addressMapper.findByAid(aid);
		if(result==null) {
			throw new AddressNotFoundException("Address not found !");
		}
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("Access denied !");
		}
		
		Integer rows = addressMapper.updateNonDefault(uid);
		if(rows<1) {
			throw new UpdateException("Update exception !");
		}
		
		rows = addressMapper.updateDefaultByAid(aid, username, new Date());
		if(rows != 1) {
			throw new UpdateException("Update exception !");
		}
	}

}
