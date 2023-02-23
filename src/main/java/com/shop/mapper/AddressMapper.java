package com.shop.mapper;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface AddressMapper {
	
	Integer insert(Address address);
	
	Integer countByUid(Integer uid);

}
