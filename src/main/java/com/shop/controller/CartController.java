package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.service.CartService;
import com.shop.utils.JsonResult;
import com.shop.vo.CartVO;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("add_to_cart")
	public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
		
		cartService.addToCart(getuidFromSession(session), 
						     pid, 
						     amount, 
						     getUsernameFromSession(session));
		return new JsonResult<>(OK);
	}
	
	@GetMapping
	public JsonResult<List<CartVO>> getVOByUid(HttpSession session){
	
		List<CartVO> data = cartService.getVOByUid(getuidFromSession(session));
		return new JsonResult<>(OK, data);
	}
	

}
