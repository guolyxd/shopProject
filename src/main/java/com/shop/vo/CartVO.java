package com.shop.vo;

import java.io.Serializable;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Mar 1, 2023
*/
@Data
public class CartVO implements Serializable{
	
	private Integer cid;
	private Integer uid;
	private Integer pid;
	private Long price;
	private Integer num;
	private String title;
	private Integer realPrice;
	private String image;

}
