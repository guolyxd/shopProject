package com.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void insert() {
		
		User user = new User();
		user.setUsername("Antony");
		user.setPassword("123");
		Integer row = userMapper.insert(user);
		System.out.println(row);
		
	}

}
