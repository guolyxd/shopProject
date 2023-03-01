package com.shop.mapper;

import java.util.Date;

import com.shop.entity.Cart;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/

public interface CartMapper {
	
	Integer insert(Cart cart);
	Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);
	Cart findByUidAndPid(Integer uid, Integer pid);
}
