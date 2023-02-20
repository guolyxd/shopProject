package com.shop.utils;

import java.io.Serializable;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
* 对所有Json类型的数据进行响应
*/
@Data
public class JsonResult <E> implements Serializable{
	private Integer state;
	private String msg;
	private E data;


	public JsonResult() {
	}

	public JsonResult(Throwable e) {
		this.msg = e.getMessage();
	}

	public JsonResult(Integer state) {
		this.state = state;
	}

	public JsonResult(Integer state, E data) {
		this.state = state;
		this.data = data;
	}


}
