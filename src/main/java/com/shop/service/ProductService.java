package com.shop.service;

import java.util.List;

import com.shop.entity.Product;

/**
* @Author:Antony
* @CreateDate:Feb 27, 2023
*/

public interface ProductService {
	
	List<Product> findHotList();
	Product findById(Integer id);

}
