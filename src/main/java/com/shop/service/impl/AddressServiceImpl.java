package com.shop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shop.entity.Address;
import com.shop.mapper.AddressMapper;
import com.shop.service.AddressService;
import com.shop.service.exception.AddressCountLimitException;
import com.shop.service.exception.InsertException;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Value("${user.address.max-count}")
	private Integer maxCount;

	@Override
	public void addNewAddress(Integer uid, String username, Address address) {
		
		Integer count =addressMapper.countByUid(uid);
		if(count >= maxCount) {
			throw new AddressCountLimitException("Exceed the max limite !");
		}
		
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
	
	
	

}
