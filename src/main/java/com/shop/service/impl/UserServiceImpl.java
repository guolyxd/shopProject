package com.shop.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
import com.shop.service.exception.InsertException;
import com.shop.service.exception.PasswordNotMatchException;
import com.shop.service.exception.UserNotFoundException;
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

		/**
		 * 密码加密处理的实现：md5算法的形式：687hn09-687hgbnin9-687gboi7-68gvut-76vyui
		 * 串 + password + 串 -----md5算法进行加密,(连续加密三次)
		 * 盐值+password+盐值 ------盐值就是一个随机的字符串
		 */
		String initPassword = user.getPassword();
		/*获取盐值（随机生成，最后大写）*/
		String salt = UUID.randomUUID().toString().toUpperCase();
		/*将盐值作为一个整体进行加密*/
		String md5Password = getMD5Password(initPassword, salt);

		user.setSalt(salt);
		user.setPassword(md5Password);
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

	private String getMD5Password(String password, String salt) {
		for(int i=0;i<3;i++) {
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
		}
		return password;
	}

	@Override
	public User login(String username, String password) {
		
		User result = userMapper.findByUsername(username);
		if(result==null) {
			throw new UserNotFoundException("User not found !");
		}
		
		//get encrypted password from mySql
		String encryptedPassword = result.getPassword();
		String salt = result.getSalt();
		String newPassword = getMD5Password(password, salt);
		if(!newPassword.equals(newPassword)) {
			throw new PasswordNotMatchException("Password not match!");
		}
		
		if(result.getIsDelete()==1) {
			throw new UserNotFoundException("User not found !");
		}
		
		return result;
	}

	@Override
	public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		User result = userMapper.findByUid(uid);
		if(result == null ||result.getIsDelete()==1) {
			throw new UserNotFoundException("User not found ！");
		}
		
		String oldMD5Password = getMD5Password(oldPassword,result.getSalt());
		System.out.println(oldMD5Password);
		if(!result.getPassword().equals(oldMD5Password)) {
			throw new PasswordNotMatchException("Password not match !");
		}
		
		String newMD5Password = getMD5Password(newPassword, result.getSalt());
		userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());
		
	}

}
