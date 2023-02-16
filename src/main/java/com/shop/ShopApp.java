package com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/
@SpringBootApplication
@MapperScan("com.shop.mapper")
public class ShopApp {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SpringApplication.run(ShopApp.class, args);

	}

}
