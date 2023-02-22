package com.shop.mapper;

import java.util.Date;

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
	
	/**
	 * 
	 * @param uid
	 * @param password
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return 返回值为受影响的行
	 */
	Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);
	
	/**
	 * 
	 * @param uid
	 * @return 成功则返回user信息，失败则返回Null
	 */
	User findByUid(Integer uid);
	
	/**
	 * 
	 * @param user
	 * @return 返回受影响的行数
	 */
	Integer updateInfoByUid(User user);

}
