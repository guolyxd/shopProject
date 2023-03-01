package com.shop.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.Cart;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTest {
	@Autowired
	private CartMapper cartMapper;

	@Test
	public void insertTest() {

		Cart cart = new Cart();
		cart.setCid(3);
		cart.setUid(5);
		cart.setPid(10000113);
		cart.setPrice(9000L);
		Integer row = cartMapper.insert(cart);
		System.out.println(row);
	}
	
	
	@Test
	public void updateNumByCidTest() {

		Integer row = cartMapper.updateNumByCid(1, 5, "Tom", new Date());
		System.out.println(row);
	}
	
	@Test
	public void findByUidAndPidTest() {

		Cart cart = cartMapper.findByUidAndPid(5, 10000099);
		System.err.println(cart);
	}

}
