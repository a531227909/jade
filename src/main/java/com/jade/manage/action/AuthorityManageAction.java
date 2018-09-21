package com.jade.manage.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.AuthorityManageService;
import com.jade.po.Result;

@Controller
@RequestMapping("/authority")
public class AuthorityManageAction {
	
	@Autowired
	private AuthorityManageService authorityService; 

	/**
	 * 获取所有权限
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getAllAuthority.action",method=RequestMethod.POST)
	public @ResponseBody Result getAllAuthority(HttpSession session){
		String accountType = (String) session.getAttribute("accountType");
		return authorityService.getAllAuthority(accountType);
		
	}
	
	/**
	 * 分配权限
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/authorityOfDistribution.action",method=RequestMethod.POST)
	public @ResponseBody Result authorityOfDistribution(HttpSession session,@RequestBody JSONObject data){
		String account = (String) session.getAttribute("account");
		return authorityService.authorityOfDistribution(data,account);
		
	}
	
	/**
	 * 获取用户列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getUserList.action",method=RequestMethod.POST)
	public @ResponseBody Result getUserList(@RequestBody JSONObject data,HttpSession session){
		String account = 
				(String)session.getAttribute("account");
		return 	authorityService.getUserList(data,account);
		
	}
	
	/**getUserList
	 * 删除用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/DelUser.action",method=RequestMethod.POST)
	public @ResponseBody Result DelUser(@RequestBody JSONObject data){
		
		return authorityService.DelUser(data);
		
	}
	
	/**
	 * 更新用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/UpdateUser.action",method=RequestMethod.POST)
	public @ResponseBody Result UpdateUser(@RequestBody JSONObject data){
		
		return authorityService.UpdateUser(data);
		
	}
	/**
	 * 添加用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/addUser.action",method=RequestMethod.POST)
	public @ResponseBody Result addUser(@RequestBody JSONObject data, HttpSession session){
		String account = (String) session.getAttribute("account");
		return authorityService.addUser(data,account);
		
	}
	
	/**
	 * 获取角色列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getRoleList.action",method=RequestMethod.POST)
	public @ResponseBody Result getRoleList(HttpSession session){
		String agentId = (String) session.getAttribute("agentId");
		return authorityService.getRoleList(agentId);
		
	}
	/**
	 * 更新角色
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/updateRole.action",method=RequestMethod.POST)
	public @ResponseBody Result updateRole(@RequestBody JSONObject data){
		
		return authorityService.updateRole(data);
		
	}
	/**
	 * 添加角色
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/addRole.action",method=RequestMethod.POST)
	public @ResponseBody Result addRole(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		String agentId = (String) session.getAttribute("agentId");
		return authorityService.addRole(data,account,agentId);
		
	}
	/**
	 * 删除角色
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/delRole.action",method=RequestMethod.POST)
	public @ResponseBody Result delRole(@RequestBody JSONObject data){
		
		return authorityService.delRole(data);
		
	}
	/**
	 * 获取角色权限
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getRoleAuthority.action",method=RequestMethod.POST)
	public @ResponseBody Result getRoleAuthority(@RequestBody JSONObject data){
		
		return authorityService.getRoleAuthority(data);
		
	}
	
	/**
	 * 获取用户业绩
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/getUserPerformance.action",method=RequestMethod.POST)
	public @ResponseBody Result getUserPerformance(@RequestBody JSONObject data){
		
		return authorityService.getUserPerformance(data);
		
	}

}
