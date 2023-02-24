package com.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.District;
import com.shop.mapper.DistrictMapper;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Feb 24, 2023
*/
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

	@Autowired
	private DistrictMapper districtMapper;
	
	
	/**
	 * districts开头的请求都被拦截到getByParent方法
	 */
	@RequestMapping({"/",""})
	public JsonResult<List<District>> getByParent(String parent){
		
		List<District> data = districtMapper.findByParent(parent);
		return new JsonResult<>(OK, data);
	}
}
