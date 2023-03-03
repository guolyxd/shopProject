package com.shop.mapper;

import java.util.Date;
import java.util.List;

import com.shop.entity.Cart;
import com.shop.vo.CartVO;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/

public interface CartMapper {
	
	Integer insert(Cart cart);
	Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);
	Cart findByUidAndPid(Integer uid, Integer pid);
	List<CartVO> findVOByUid(Integer uid);
	Cart findByCid(Integer cid);
	List<CartVO> findVOByCid(Integer[] cids);
}
