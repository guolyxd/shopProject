package com.shop.service.exception;
/**
* @Author:Antony
* @CreateDate:Feb 21, 2023
* 用户在更新数据时产生的未知异常
*/

public class UpdateException extends ServiceException{

	public UpdateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
