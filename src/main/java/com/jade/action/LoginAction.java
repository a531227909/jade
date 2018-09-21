package com.jade.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.mod.Agent;
import com.jade.mod.User;
import com.jade.mod.UserExample;
import com.jade.mod.UserExample.Criteria;
import com.jade.po.Result;
import com.jade.service.UserService;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;

@Controller()
@RequestMapping("/user")
public class LoginAction {

	@Autowired
	private UserService userService;
	
	public static  Map<String, Object> USER_SESSION = new HashMap<String, Object>();  
	
	public static  Map<String, Object> USERMANAGE_SESSION = new HashMap<String, Object>();  

	
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public @ResponseBody Result login(HttpSession session,@RequestParam(required=true)String account,@RequestParam(required=true)String password){
		
		Result result = new Result();
		if("".equals(account)){
			result.setSuccess(false);
			result.getResult().put("error", "账号不能为空");
			return result;
			}else{
				String flag = userService.login(account, password);
				if(flag==Const.LOGIN_SUCCESS){
					Map<String,Object> map = userService.loginManage(account, password);
					User user = (User) map.get("user");
					Agent agent = (Agent) map.get("agent");
					if(!"0".equals(user.getUsetype())){
						session.setAttribute("account", account);
						session.setAttribute("userId", user.getId());
						session.setAttribute("agentId", user.getSid());
						session.setAttribute("loginId",session.getId() );
				
						result.setSuccess(true);
						result.getResult().put("success", "登录成功");
						result.getResult().put("agent", agent.getSname());
						result.getResult().put("img", ImageUtil.getUrl(user.getHeadimg(), 60*1000));
						result.getResult().put("telephone", user.getTelephone());
						result.getResult().put("accountType", user.getAccounttype());
					}else{
						result.setSuccess(false);
						result.getResult().put("error", "账号已被停用");
					}
				}else if(flag ==Const.LOGIN_ERROR_ACCOUNT){
					result.setSuccess(false);
					result.getResult().put("error", "账号不存在");
				}else if(flag == Const.LOGIN_ERROR_PWD){
					result.getResult().put("error", "账号或密码错误");
				}
				return result;
				}
		}
	
	@RequestMapping(value="/loginManage.action",method=RequestMethod.POST)
	public @ResponseBody Result loginManage(HttpSession session,@RequestParam(required=true)String account,@RequestParam(required=true)String password){
		
		Result result = new Result();
		if("".equals(account)){
			result.setSuccess(false);
			result.getResult().put("error", "账号不能为空");
			return result;
			}else{
				String flag = userService.login(account, password);
				if(flag==Const.LOGIN_SUCCESS){
					Map<String,Object> map1 = userService.loginManage(account, password);
					User user = (User) map1.get("user");
					
					if(!"2".equals(user.getAccounttype())){
						if(!"0".equals(user.getUsetype())){
							Map<String,Object> map = new HashMap<String,Object>();
							List<String> list = userService.getAuthority(account);
							session.setAttribute("account", user.getAccount());
							session.setAttribute("userId", user.getId());
							session.setAttribute("agentId", user.getSid());
							session.setAttribute("accountType", user.getAccounttype());
							session.setAttribute("loginManageId",session.getId());
					
						   
							map.put("sid", user.getSid());
							map.put("accountType", user.getAccounttype());
							map.put("img", ImageUtil.getUrl(user.getHeadimg(),60*1000));
							map.put("data", list);
							result.setSuccess(true);
							result.setResult(map);
						}else{
							result.setSuccess(false);
							result.getResult().put("error", "账号已被停用");
						}
						
					}else{
						result.setSuccess(false);
						result.getResult().put("error", "用户账号不能登录后台，请使用管理员或代理商账号登录");
					}
					
				}else if(flag ==Const.LOGIN_ERROR_ACCOUNT){
					result.setSuccess(false);
					result.getResult().put("error", "账号不存在");
				}else if(flag == Const.LOGIN_ERROR_PWD){
					result.getResult().put("error", "账号或密码错误");
				}
				return result;
				}
		}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/outLogin.action",method=RequestMethod.POST)
	public @ResponseBody Result outLogin(HttpSession session,HttpServletRequest request) throws Exception{
		String user = (String) session.getAttribute("account");
		Result result = new Result();
		if (user != null) {
			//session.invalidate();
			USER_SESSION.remove(session.getAttribute("account"));
		
			session.removeAttribute("account");
			
			//session = request.getSession(true);
			result.setSuccess(true);
			}
		return result;
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/outManageLogin.action",method=RequestMethod.POST)
	public @ResponseBody Result outManageLogin(HttpSession session,HttpServletRequest request) throws Exception{
		String user = (String) session.getAttribute("account");
		Result result = new Result();
		if (user != null) {
			//session.invalidate();
			USERMANAGE_SESSION.remove(session.getAttribute("account"));
			
			session.removeAttribute("account");
			//session = request.getSession(true);
			result.setSuccess(true);
			}
		return result;
	}
	
	/**
	 * 用户信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getUser.action",method=RequestMethod.POST)
	public @ResponseBody Result getUser(HttpSession session){
		String account = (String) session.getAttribute("account");
		
		return userService.getUser(account);
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updateUserPwd.action",method=RequestMethod.POST)
	public @ResponseBody Result updateUserPwd(HttpSession session,String oldPassword,String password){
		String account = (String) session.getAttribute("account");
		String useId = (String) session.getAttribute("userId");
		return userService.updateUserPwd(useId,account,oldPassword,password,session);
	}

	/**
	 * 修改用户姓名
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updateUserName.action",method=RequestMethod.POST)
	public @ResponseBody Result updateUserName(HttpSession session,String name){
		String account = (String) session.getAttribute("account");
		String useId = (String) session.getAttribute("userId");
		return userService.updateUserName(useId,account,name);
	}
	
	/**
	 * 修改用户图片
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updateUserImg.action",method=RequestMethod.POST)
	public @ResponseBody Result updateUserImg(HttpSession session,String img){
		String account = (String) session.getAttribute("account");
		return userService.updateUserImg(account,img);
	}

}
