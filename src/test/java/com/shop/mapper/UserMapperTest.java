package com.shop.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.User;

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
	@Test
	public void updatePasswordByUidTest() {
		userMapper.updatePasswordByUid(2, "r7491", "ccddeeff", new Date());
	}
	
	@Test
	public void findByUidTest() {
		System.out.println(userMapper.findByUid(3));
	}
	
	@Test
	public void updateInfoByUidTest() {
		User user = new User();
		user.setUid(5);
		user.setEmail("1234@163.com");
		user.setPhone("13888888888");
		user.setGender(1);
		userMapper.updateInfoByUid(user);
	}

}
