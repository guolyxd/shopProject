package com.shop.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @Author:Antony
* @CreateDate:Feb 21, 2023
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@Test
	public void createTest() {
		
		Integer[] cids = {4,7,8};
		orderServiceImpl.create(4, 5, "Tom01", cids);
		
	}

}
