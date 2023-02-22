package com.shop.service;

import com.shop.entity.User;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/

public interface UserService {

	void registUser(User user);
	User login(String username, String password);
	void changePassword(Integer uid, String username, String oldPassword,String newPassword);

}
