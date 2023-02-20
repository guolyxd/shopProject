package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/
@Data
public class BaseEntity implements Serializable{

	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;

}
