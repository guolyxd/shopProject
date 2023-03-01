package com.shop.service;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/

public interface CartService {
	
	void addToCart(Integer uid, Integer pid, Integer amount, String username);

}
