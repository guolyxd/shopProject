package com.shop.service;

import com.shop.entity.Order;

/**
* @Author:Antony
* @CreateDate:Mar 7, 2023
*/

public interface OrderService {
	
	Order create(Integer aid, Integer uid, String username, Integer[] cids);

}
