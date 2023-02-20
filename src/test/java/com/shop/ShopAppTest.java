package com.shop;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopAppTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() {

	}

	@Test
	public void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}


}
