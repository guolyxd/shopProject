package com.shop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
import com.shop.service.exception.InsertException;
import com.shop.service.exception.UsernameDuplicatedException;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void registUser(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		User result = userMapper.findByUsername(username);
		
		if(result != null) {
			throw new UsernameDuplicatedException("An exist username");
		}
		
		user.setIsDelete(0);
		user.setCreatedUser(user.getUsername());
		user.setModifiedUser(user.getUsername());
		Date date = new Date();
		user.setCreatedTime(date);
		user.setModifiedTime(date);
		
		
		Integer rows = userMapper.insert(user);
		if (rows != 1) {
			throw new InsertException("Insert error!");
		}
		
	}

}
