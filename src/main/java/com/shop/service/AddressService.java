package com.shop.service;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface AddressService {
	
	void addNewAddress(Integer uid, String username, Address address);

}
