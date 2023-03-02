package com.shop.service;

import java.util.List;

import com.shop.vo.CartVO;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/

public interface CartService {
	
	void addToCart(Integer uid, Integer pid, Integer amount, String username);
	List<CartVO> getVOByUid(Integer uid);
	
}
