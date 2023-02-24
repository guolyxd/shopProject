package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shop.handler.LoginInterceptor;

/**
* @Author:Antony
* @CreateDate:Feb 20, 2023
*/
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//创建自定义拦截器对象
		HandlerInterceptor interceptor = new LoginInterceptor(); 
		registry.addInterceptor(interceptor)
		        .addPathPatterns("/**")
		        .excludePathPatterns("/bootstrap3/**")
		        .excludePathPatterns("/css/**")
		        .excludePathPatterns("/images/**")
		        .excludePathPatterns("/js/**")
		        .excludePathPatterns("/web/register.html")
		        .excludePathPatterns("/web/login.html")
		        .excludePathPatterns("/web/index.html")
		        .excludePathPatterns("/web/product.html")
		        .excludePathPatterns("/users/reg")
		        .excludePathPatterns("/users/login")
		        .excludePathPatterns("/web/")
		        .excludePathPatterns("/districts/**");
	}


}
