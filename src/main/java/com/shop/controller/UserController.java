package com.shop.controller;

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
	

}
