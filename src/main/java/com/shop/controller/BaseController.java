package com.shop.controller;
/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shop.service.exception.InsertException;
import com.shop.service.exception.PasswordNotMatchException;
import com.shop.service.exception.ServiceException;
import com.shop.service.exception.UserNotFoundException;
import com.shop.service.exception.UsernameDuplicatedException;
import com.shop.utils.JsonResult;

public class BaseController {
	public static int OK = 200;

	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult<Void> result = new JsonResult<>(e);
		if(e instanceof UsernameDuplicatedException) {
			result.setState(4000);
			result.setMsg("Exist username");
		} else if(e instanceof UserNotFoundException) {
			result.setState(5001);
			result.setMsg("User not found exception !");
		}else if(e instanceof PasswordNotMatchException) {
			result.setState(5002);
			result.setMsg("Password not match exception!");
		}else if(e instanceof InsertException) {
			result.setState(5000);
			result.setMsg("Insert error!");
		}

		return result;
	}
	
	protected final Integer getuidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}

}
