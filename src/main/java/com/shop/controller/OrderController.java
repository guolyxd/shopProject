package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Order;
import com.shop.service.OrderService;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Mar 8, 2023
*/

@RequestMapping("orders")
@RestController
public class OrderController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("create")
	public JsonResult<Order> createOrder(Integer aid, Integer[] cids, HttpSession session){
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		Order data = orderService.create(aid, uid, username, cids);
		
		return new JsonResult<>(OK, data);
		
	}

}
