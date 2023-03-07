package com.shop.mapper;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;

/**
* @Author:Antony
* @CreateDate:Mar 7, 2023
*/

public interface OrderMapper {
	
	Integer insertOrder(Order order);
	Integer insertOrderItem(OrderItem orderItem);

}
