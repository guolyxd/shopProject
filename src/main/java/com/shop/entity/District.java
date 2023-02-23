package com.shop.entity;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Feb 23, 2023
*/
@Data
public class District extends BaseEntity{
	
	private Integer id;
	private String parent;
	private String code;
	private String name;
	
}
