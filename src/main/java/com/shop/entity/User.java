package com.shop.entity;

import java.io.Serializable;

import lombok.Data;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/
@Data
public class User extends BaseEntity implements Serializable{

	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private String phone;
	private String email;
	private Integer gender;
	private String avatar;
	private Integer isDelete;

}
