package com.shop.entity;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/
@Data
public class Cart extends BaseEntity{
	
	private Integer cid;
	private Integer uid;
	private Integer pid;
	private Long price;
	private Integer num;

}
