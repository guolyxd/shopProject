package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.mapper.CartMapper;
import com.shop.mapper.ProductMapper;
import com.shop.service.CartService;
import com.shop.service.exception.InsertException;
import com.shop.service.exception.UpdateException;
import com.shop.vo.CartVO;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
		
		Cart result = cartMapper.findByUidAndPid(uid, pid);
		Date date = new Date();
		if(result==null) {
			Cart cart = new Cart();
			cart.setUid(uid);
			cart.setPid(pid);
			cart.setNum(amount);
			
			Product product = productMapper.findById(pid);
			cart.setPrice(product.getPrice());
			cart.setCreatedUser(username);
			cart.setCreatedTime(date);
			cart.setModifiedUser(username);
			cart.setModifiedTime(date);
			
			Integer rows = cartMapper.insert(cart);
			if(rows==0) {
				throw new InsertException("Cart insert exception!");
			}
			
		} else {
			Integer num = result.getNum()+amount;
			Integer rows = cartMapper.updateNumByCid(result.getCid(), 
													num, 
													username, 
													date);
			if(rows!=1) {
				throw new UpdateException("Update Exception !");
			}
			
		}
		
	}

	@Override
	public List<CartVO> getVOByUid(Integer uid) {
		
		return cartMapper.findVOByUid(uid);
		
	}

}
