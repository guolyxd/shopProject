package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shop.controller.FileException.FileEmptyException;
import com.shop.controller.FileException.FileSizeException;
import com.shop.controller.FileException.FileStateException;
import com.shop.controller.FileException.FileTypeException;
import com.shop.controller.FileException.FileUploadIOException;
import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.utils.JsonResult;

/**
* @Author:Antony
* @CreateDate:Feb 17, 2023
*/
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;

	@RequestMapping("reg")
	public JsonResult<Void> registUser(User user){

		userService.registUser(user);
		return new JsonResult<>(OK);

	}
	
	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session){
		
		User data = userService.login(username, password);
		//attach user info into session which will be useful in future .
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		return new JsonResult<User>(OK, data);
	}
	
	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changePassword(uid, username, oldPassword, newPassword);
		
		return new JsonResult<>(OK);
		
	}
	
	@RequestMapping("get_by_uid")
	public JsonResult<User> getByUid(HttpSession session){
		User data = userService.getByUid(getuidFromSession(session));
		
		return new JsonResult<>(OK, data);
	}
	
	@RequestMapping("change_info")
	public JsonResult<Void> changeInfo(User user, HttpSession session){
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changeInfo(uid, username, user);
		
		return new JsonResult<>(OK);
	}
	
	
	
	/**
	 * file upload preparation
	 */
	public static final int AVATAR_MAX=10*1024*1024;
	public static final List<String> AVATAR_TYPE= new ArrayList<>();
	       static {
	    	   AVATAR_TYPE.add("image/jpeg");
	    	   AVATAR_TYPE.add("image/png");
	    	   AVATAR_TYPE.add("image/bmp");
	    	   AVATAR_TYPE.add("image/gif");
	       }
	@RequestMapping("change_avatar")
	public JsonResult<String> updateAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
		
		if(file.isEmpty()) {
			throw new FileEmptyException("File is empty !");
		}
		if(file.getSize()>AVATAR_MAX) {
			throw new FileSizeException("File size exceed the max limiatation !");
		}
		
		String contentType=file.getContentType();
		if(!AVATAR_TYPE.contains(contentType)) {
			throw new FileTypeException("File type exception");
		}
		
		String parent=session.getServletContext().getRealPath("upload");
		File dir = new File(parent);
		if(!dir.exists()) { //??????????????????????????????
			dir.mkdir();    //????????????????????????
		}
		
		String originalFilename = file.getOriginalFilename();
		int index = originalFilename.lastIndexOf(".");
		String suffix = originalFilename.substring(index);
		String fileName= UUID.randomUUID().toString().toUpperCase() + suffix;
		
		File dest = new File(dir, fileName);
		try {
			file.transferTo(dest);
		} catch (FileStateException e) {
			throw new FileStateException("File state exception !");
		} catch (IOException e) {
			throw new FileUploadIOException("File IO exception !");
		}
		
		//?????????????????????/upload/test.png
		String avatar = "/upload/" + fileName;
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changeAvatar(uid, avatar, username);

		//???????????????????????????????????????????????????????????????????????????
		return new JsonResult<>(OK, avatar);
	}
	
	
	


}
