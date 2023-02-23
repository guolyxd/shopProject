package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.Address;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTest {

	@Autowired
	private AddressMapper addressMapper;

	@Test
	public void insertTest() {

		Address address = new Address();
		address.setUid(5);
		address.setPhone("13899999999");
		Integer row = addressMapper.insert(address);
		System.out.println(row);
	}
	
	@Test
	public void countUidTest() {
		Integer count = addressMapper.countByUid(5);
		System.out.println(count);
	}
	

}
