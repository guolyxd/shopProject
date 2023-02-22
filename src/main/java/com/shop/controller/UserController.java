package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;

	@RequestMapping("reg")
	public JsonResult<Void> registUser(User user){

		userService.registUser(user);
		return new JsonResult<>(OK);

	}
	
	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session){
		
		
		User data = userService.login(username, password);
		
		//attach user info into session which will be useful in future .
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		return new JsonResult<User>(OK, data);
	}
	
	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changePassword(uid, username, oldPassword, newPassword);
		
		return new JsonResult<>(OK);
		
	}


}
