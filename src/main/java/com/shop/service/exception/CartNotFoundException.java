package com.shop.service.exception;
/**
* @Author:Antony
* @CreateDate:Mar 2, 2023
*/

public class CartNotFoundException extends ServiceException{

	public CartNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
