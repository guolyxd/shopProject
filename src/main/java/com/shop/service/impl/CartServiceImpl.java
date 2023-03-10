package com.shop.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.mapper.CartMapper;
import com.shop.mapper.ProductMapper;
import com.shop.service.CartService;
import com.shop.service.exception.AccessDeniedException;
import com.shop.service.exception.CartNotFoundException;
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

	@Override
	public Integer addNum(Integer cid, Integer uid, String username) {
		
		Cart result = cartMapper.findByCid(cid);
		if(result==null) {
			throw new CartNotFoundException("Cart not found");
		}
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("Access denied !");
		}
		
		Integer num = result.getNum()+1;
		Integer rows=cartMapper.updateNumByCid(cid, num, username, new Date());
		if(rows!=1) {
			throw new UpdateException("Update exception");
		}
		
		return num;
	}

	@Override
	public List<CartVO> getVOByCid(Integer uid, Integer[] cids) {
		
		List<CartVO> list = cartMapper.findVOByCid(cids);
		Iterator<CartVO> it= list.iterator();
		while(it.hasNext()) {
			CartVO cartVo= it.next();
			if(!cartVo.getUid().equals(uid)) {
				list.remove(cartVo);
			}
		}
		
		return list;
	}

}
