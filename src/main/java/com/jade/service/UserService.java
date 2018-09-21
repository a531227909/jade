package com.jade.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.jade.mod.User;
import com.jade.po.Result;

public interface UserService {

	public String login(String account,String password);
	
	public Map loginManage(String account,String password);
	
	public Result getUser(String account);
	
	public Result updateUserName(String useId,String account,String name);
	
	public Result updateUserPwd(String useId,String account,String oldPassword,String password,HttpSession session);
	/**
	 * 获取用户权限
	 * @param account
	 * @return
	 */
	public List<String> getAuthority(String account);
	
	public Result updateUserImg(String account,String img);
}
