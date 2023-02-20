package com.shop.mapper;

import com.shop.entity.User;

/**
* @Author:Antony
* @CreateDate:Feb 16, 2023
*/

public interface UserMapper {
	/**
	 *
	 * @param user
	 * @return 返回值类型为受影响的行数（增,删,改,查都受影响的行数为返回值）
	 */
	Integer insert (User user);

	/**
	 *
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

}
