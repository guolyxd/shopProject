package com.shop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.User;
import com.shop.service.exception.ServiceException;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void registUser() {
		
		try {
			User user = new User();
			user.setUsername("abcd");
			user.setPassword("234");
			userService.registUser(user);
			System.out.println("nice");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
	}

}
