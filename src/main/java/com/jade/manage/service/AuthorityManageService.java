package com.jade.manage.service;

import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface AuthorityManageService {
	/**
	 * 获取所有权限
	 * @return
	 */
	public Result getAllAuthority(String accountType);
	/**
	 * 分配权限
	 * @return
	 */
	public Result authorityOfDistribution(JSONObject data,String account);
	/**
	 * 获取用户列表
	 * @param data
	 * @return
	 */
	public Result getUserList(JSONObject data,String account);
	/**
	 * 删除用户
	 */
	public Result DelUser(JSONObject data);
	/**
	 * 修改用户信息
	 * @param data
	 * @return
	 */
	public Result UpdateUser(JSONObject data);
	/**
	 * 添加用户
	 */
	public Result addUser(JSONObject data,String userId);
	/**
	 * 获取角色列表
	 * @param data
	 * @return
	 */
	public Result getRoleList(String account);
	/**
	 * 获取角色权限
	 * @param data
	 * @return
	 */
	public Result getRoleAuthority(JSONObject data);
	/**
	 * 修改角色信息
	 */
	public Result updateRole(JSONObject data); 
	/**
	 * 添加角色
	 * @param data
	 * @param account
	 * @return
	 */
	public Result addRole(JSONObject data,String account,String sid);
	/**
	 * 删除角色
	 * @param data
	 * @return
	 */
	public Result delRole(JSONObject data);
	
	public Result addManageUser(JSONObject data, String userId);
	/**
	 * 获取用户业绩
	 * @param account
	 * @return
	 */
	public Result getUserPerformance(JSONObject data);
}
