package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Address;
import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.mapper.OrderMapper;
import com.shop.service.AddressService;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import com.shop.service.exception.InsertException;
import com.shop.vo.CartVO;

/**
* @Author:Antony
* @CreateDate:Mar 7, 2023
*/
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CartService cartService;
	
	@Override
	public Order create(Integer aid, Integer uid, String username, Integer[] cids) {
		
		List<CartVO> list = cartService.getVOByCid(uid, cids);
		Long totalPrice= 0L;
		for(CartVO c:list) {
			totalPrice +=c.getRealPrice()* c.getNum();
		}
		
		Address address = addressService.getByAid(aid, uid);
		Order order = new Order();
		order.setUid(uid);
		order.setRecvName(address.getName());
		order.setRecvPhone(address.getPhone());
		order.setRecvProvince(address.getProvinceName());
		order.setRecvCity(address.getCityCode());
		order.setRecvArea(address.getAreaName());
		order.setRecvAddress(address.getAddress());
		
		order.setStatus(0);
		order.setTotalPrice(totalPrice);
		order.setOrderTime( new Date());
		
		order.setCreatedUser(username);
		order.setCreatedTime(new Date());
		order.setModifiedTime(new Date());
		order.setModifiedUser(username);
		
		Integer rows= orderMapper.insertOrder(order);
		
		if(rows != 1) {
			throw new InsertException("Insert Exception!");
		}
		
		for(CartVO c:list) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOid(order.getOid());
			orderItem.setPid(c.getPid());
			orderItem.setTitle(c.getTitle());
			orderItem.setImage(c.getImage());
			orderItem.setPrice(c.getRealPrice());
			orderItem.setNum(c.getNum());
			orderItem.setCreatedUser(username);
			orderItem.setCreatedTime(new Date());
			orderItem.setModifiedUser(username);
			orderItem.setModifiedTime(new Date());
			
			rows = orderMapper.insertOrderItem(orderItem);
			if(rows != 1) {
				throw new InsertException("Insert exception!");
			}
			
		}
		
		
		return order;
	}

}
