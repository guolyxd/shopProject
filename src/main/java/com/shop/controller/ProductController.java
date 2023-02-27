package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Feb 27, 2023
*/
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

	@Autowired
	private ProductService productService;
	
	@RequestMapping("hot_list")
	public JsonResult<List<Product>> getHotList(){
		List<Product> data = productService.findHotList();
		return new JsonResult<List<Product>>(OK, data);
	}
	
	@GetMapping("{id}/details")
	public JsonResult<Product> getById(@PathVariable("id") Integer id){
		Product data = productService.findById(id);
		return new JsonResult<Product>(OK, data);
	}
}
