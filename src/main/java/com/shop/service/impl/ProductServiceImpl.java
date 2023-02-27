package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Product;
import com.shop.mapper.ProductMapper;
import com.shop.service.ProductService;
import com.shop.service.exception.ProductNotFoundException;

/**
* @Author:Antony
* @CreateDate:Feb 27, 2023
*/
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findHotList() {
		
		List<Product> list = productMapper.findHotList();
		return list;
	}

	@Override
	public Product findById(Integer id) {
		
		Product product = productMapper.findById(id);
		if(product==null) {
			throw new ProductNotFoundException("Product not found exception !");
		}
		return product;
	}

}
