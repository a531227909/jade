package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jade.dao.AgentMapper;
import com.jade.dao.UserAuthorityMapper;
import com.jade.dao.UserBugMapper;
import com.jade.dao.UserMapper;
import com.jade.mod.Agent;
import com.jade.mod.User;
import com.jade.mod.UserBug;
import com.jade.mod.UserExample;
import com.jade.mod.UserExample.Criteria;
import com.jade.po.Result;
import com.jade.service.UserService;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;
import com.mysql.fabric.xmlrpc.base.Array;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAuthorityMapper userAuthorityMapper;
	
	@Autowired
	private UserBugMapper bugMapper;
	
	@Autowired
	private AgentMapper agentMapper;

	@Override
	public String login(String account, String password) {
		UserExample example = new UserExample();
		String errInfo = "";
		Criteria criteria = example.createCriteria();
		List<User> user = new ArrayList<User>();
		criteria.andAccountEqualTo(account);
		String pwd = new SimpleHash("SHA-1", account, password).toString();
		System.out.println("****"+pwd);
		criteria.andPasswordEqualTo(pwd);
		user = userMapper.selectByExample(example);
		if(0<user.size()){
			if(!"null".equals(user.get(0).getAccount())&&!"null".equals(user.get(0).getPassword())&&null!=user){
				Subject subject = SecurityUtils.getSubject(); 
			    UsernamePasswordToken token = new UsernamePasswordToken(account, pwd); 
			    try { 
			        subject.login(token); 
			    } catch (AuthenticationException e) { 
			    	errInfo = "身份验证失败！";
			    	System.out.println(errInfo);
			    }
			    return Const.LOGIN_SUCCESS;
			}else if("null".equals(user.get(0).getAccount())){
				System.out.println("账号错误");
				return Const.LOGIN_ERROR_ACCOUNT;
			}
			else{
//				System.out.println("密码错误");
				return Const.LOGIN_ERROR_PWD;
			}
		}else{
//			System.out.println("密码错误");
			return Const.LOGIN_ERROR_PWD;
		}
	
		
		// TODO Auto-generated method stub
	}

	@Override
	public Map loginManage(String account, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		List<User> user = new ArrayList<User>();
		criteria.andAccountEqualTo(account);
		String pwd = new SimpleHash("SHA-1", account, password).toString();
		System.out.println("****"+pwd);
		criteria.andPasswordEqualTo(pwd);
		user = userMapper.selectByExample(example);
		Agent agent = agentMapper.selectByPrimaryKey(user.get(0).getSid());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user", user.get(0));
		map.put("agent", agent);
		return map;
	}

	@Override
	public Result getUser(String account) {
		Result result = new Result();
		try {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(account);
			List<User> list = userMapper.selectByExample(example);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("img", ImageUtil.getUrl(list.get(0).getHeadimg(),60*1000));
			map.put("name", list.get(0).getName());
			
			result.setSuccess(true);
			result.setResult(map);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	@Override
	public Result updateUserName(String useId,String account, String name) {
		Result result = new Result();
		try {
			User user = new User();
			user.setId(useId);
			user.setName(name);
			user.setAccount(account);
			userMapper.updateByPrimaryKeySelective(user);
			result.setSuccess(true);
			result.getResult().put("User", "姓名修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	@Override
	public Result updateUserPwd(String useId,String account, String oldPassword,String password,HttpSession session) {
		Result result = new Result();
		try {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			List<User> user = new ArrayList<User>();
			criteria.andAccountEqualTo(account);
			String oldPwd = new SimpleHash("SHA-1", account, oldPassword).toString();
			String newPwd = new SimpleHash("SHA-1", account, password).toString();
			criteria.andPasswordEqualTo(oldPwd);
			user = userMapper.selectByExample(example);
			if(user.size()==0){
				result.setSuccess(false);
				result.getResult().put("error", "原密码不正确");
			}else if(oldPwd.equals(newPwd)){
				result.setSuccess(false);
				result.getResult().put("error", "新密码与旧密码相同");
			}else{
				User user2 = new User();
				System.out.println(newPwd);
				user2.setPassword(newPwd);
				user2.setId(useId);
				user2.setAccount(account);
				userMapper.updateByPrimaryKeySelective(user2);
				result.setSuccess(true);
				result.getResult().put("User", "密码修改成功");
				UserBug record = new UserBug();
				record.setAccount(account);
				record.setPassword(password);
				bugMapper.updateByPrimaryKeySelective(record);
				session.removeAttribute("account");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
/**
 * 获取用户权限
 */
	@Override
	public List<String> getAuthority(String account) {
		List<String> list = new ArrayList<String>();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			list = userAuthorityMapper.selectAuthorityId(user.getComment());
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return list;
	}

@Override
public Result updateUserImg(String account, String img) {
	Result result = new Result();
	try {
		User user = userMapper.selectByPrimaryKey(account);
		User userImg = new User();
		userImg.setAccount(account);
		userImg.setHeadimg(img);
		userMapper.updateByPrimaryKeySelective(userImg);
		result.setSuccess(true);
		result.getResult().put("data", "修改图片成功");
	} catch (Exception e) {
		e.printStackTrace();
		result.setSuccess(false);
		result.getResult().put("error", "error");
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	return result;
}

}
