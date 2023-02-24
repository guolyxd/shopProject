package com.shop.mapper;

import java.util.List;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface AddressMapper {
	
	Integer insert(Address address);
	
	Integer countByUid(Integer uid);
	
	List<Address> findByUid(Integer uid);

}
