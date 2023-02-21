package com.shop.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
* @Author:Antony
* @CreateDate:Feb 20, 2023
*/


public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object obj = request.getSession().getAttribute("uid");
		if(obj == null) {
			response.sendRedirect("/web/login.html");
			return false;
		}
		return true;
	}
}
