package com.shop.controller;
/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shop.controller.FileException.FileEmptyException;
import com.shop.controller.FileException.FileSizeException;
import com.shop.controller.FileException.FileStateException;
import com.shop.controller.FileException.FileTypeException;
import com.shop.controller.FileException.FileUploadException;
import com.shop.controller.FileException.FileUploadIOException;
import com.shop.service.exception.AddressCountLimitException;
import com.shop.service.exception.InsertException;
import com.shop.service.exception.PasswordNotMatchException;
import com.shop.service.exception.ServiceException;
import com.shop.service.exception.UpdateException;
import com.shop.service.exception.UserNotFoundException;
import com.shop.service.exception.UsernameDuplicatedException;
import com.shop.utils.JsonResult;

public class BaseController {
	public static int OK = 200;

	@ExceptionHandler({ServiceException.class, FileUploadException.class})
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult<Void> result = new JsonResult<>(e);
		if(e instanceof UsernameDuplicatedException) {
			result.setState(4000);
			result.setMsg("Exist username");
		} else if(e instanceof UserNotFoundException) {
			result.setState(4001);
			result.setMsg("User not found exception !");
		}else if(e instanceof PasswordNotMatchException) {
			result.setState(4002);
			result.setMsg("Password not match exception!");
		}else if(e instanceof AddressCountLimitException) {
			result.setState(4003);
			result.setMsg("Address count limit exception!");
		}else if(e instanceof InsertException) {
			result.setState(5001);
			result.setMsg("Insert error!");
		}else if(e instanceof UpdateException) {
			result.setState(5002);
			result.setMsg("Update error!");
		}else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMsg("File empty!");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMsg("File size errror!");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMsg("File type error!");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMsg("File states error!");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMsg("File upload error!");
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
