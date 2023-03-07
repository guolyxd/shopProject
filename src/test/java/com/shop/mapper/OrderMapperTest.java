package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {
	@Autowired
	private OrderMapper orderMapper;
	
//	@Autowired
//	private OrderItemMapper orderItemMapper;

	@Test
	public void insertOrderTest() {

		Order order = new Order();
		order.setUid(5);
		order.setRecvName("yyyyy");
		order.setRecvPhone("13899990000");
		Integer data = orderMapper.insertOrder(order);
		System.out.println(data);
	}
	
	@Test
	public void insertOrderItemTest() {

		OrderItem orderItem = new OrderItem();
		orderItem.setOid(1);
		orderItem.setPid(10000018);
		orderItem.setTitle("hello world ");
		Integer data = orderMapper.insertOrderItem(orderItem);
		System.out.println(data);
	}


}
