package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Address;
import com.shop.service.AddressService;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("add_new_address")
	public JsonResult<Void> addNewAddress(Address address, HttpSession session){
		
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.addNewAddress(uid, username, address);
		return new JsonResult<>(OK);
		
	}
	
	@RequestMapping({"","/"})
	public JsonResult<List<Address>> getByUid(HttpSession session){
		
		Integer uid = getuidFromSession(session);
		List<Address> list = addressService.getByUid(uid);
		
		return new JsonResult<>(OK, list);
	}
	
	@RequestMapping("{aid}/set_default")
	public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
		
		addressService.updateDefaultAddress(aid, 
				                            getuidFromSession(session), 
				                            getUsernameFromSession(session));
		return new JsonResult<>(OK);
	}
	
	@RequestMapping("{aid}/delete")
	public JsonResult<Void> deleteAddress(@PathVariable("aid") Integer aid, HttpSession session) {
		addressService.delete(aid, 
				             getuidFromSession(session), 
				             getUsernameFromSession(session));
		
		return new JsonResult<>(OK);
	}
	

}
