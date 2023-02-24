package com.shop.service;

import java.util.List;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface AddressService {
	
	void addNewAddress(Integer uid, String username, Address address);
	List<Address> getByUid(Integer uid);

}
