package com.shop.controller;
/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shop.service.exception.InsertException;
import com.shop.service.exception.ServiceException;
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
		} else if(e instanceof InsertException) {
			result.setState(5000);
			result.setMsg("Insert error!");
		}

		return result;
	}

}
