package com.shop.service.exception;
/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/

public class UsernameDuplicatedException extends ServiceException {

	public UsernameDuplicatedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicatedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
