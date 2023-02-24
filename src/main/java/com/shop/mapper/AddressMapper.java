package com.shop.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/

public interface AddressMapper {
	
	Integer insert(Address address);
	Integer countByUid(Integer uid);
	List<Address> findByUid(Integer uid);
	Address findByAid(Integer aid);
	Integer updateNonDefault(Integer uid);
	Integer updateDefaultByAid(@Param("aid") Integer aid, 
			                   @Param("modifiedUser") String modifiedUser, 
			                   @Param("modifiedTime") Date modifiedTime);

}
