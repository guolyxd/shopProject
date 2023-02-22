package com.shop.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

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
	
	/**
	 * 占位符@Param("SQL映射文件中#{}占位符的变量名")；解决的问题是当SQL语句中的占位符和映射的接口方法参数名不一致时，
	 * 需要将某个参数强行注入到某个占位符变量上时，可以使用@Param注解来标识映射关系。
	 */
	Integer updateAvatarByUid(@Param("uid") Integer uid,
			                  @Param("avatar") String avatar,
			                  @Param("modifiedUser") String modifiedUser,
			                  @Param("modifiedTime") Date modifiedTime);

}
