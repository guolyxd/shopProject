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
public class UserServiceImplTest {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void changePasswordTest() {
		userServiceImpl.changePassword(5, "Tom01", "Test", "test");
		
	}

}
