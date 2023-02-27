package com.shop.mapper;

import java.util.List;

import com.shop.entity.Product;

/**
* @Author:Antony
* @CreateDate:Feb 27, 2023
*/

public interface ProductMapper {

	List<Product> findHotList();
	Product findById(Integer id);

}
