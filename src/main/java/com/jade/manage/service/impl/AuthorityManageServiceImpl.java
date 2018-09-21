package com.jade.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jade.dao.AgentMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.FirstAuthorityMapper;
import com.jade.dao.RoleMapper;
import com.jade.dao.SecondAuthorityMapper;
import com.jade.dao.ThirdlyAuthorityMapper;
import com.jade.dao.UorderMapper;
import com.jade.dao.UserAuthorityMapper;
import com.jade.dao.UserBugMapper;
import com.jade.dao.UserMapper;
import com.jade.manage.service.AuthorityManageService;
import com.jade.mod.Agent;
import com.jade.mod.Commodity;
import com.jade.mod.FirstAuthority;
import com.jade.mod.FirstAuthorityExample;
import com.jade.mod.FirstAuthorityExample.Criteria;
import com.jade.mod.Role;
import com.jade.mod.RoleExample;
import com.jade.mod.SecondAuthority;
import com.jade.mod.SecondAuthorityExample;
import com.jade.mod.ThirdlyAuthority;
import com.jade.mod.ThirdlyAuthorityExample;
import com.jade.mod.Uorder;
import com.jade.mod.UorderExample;
import com.jade.mod.User;
import com.jade.mod.UserAuthority;
import com.jade.mod.UserAuthorityExample;
import com.jade.mod.UserBug;
import com.jade.mod.UserExample;
import com.jade.po.Result;
import com.jade.uitil.UuidUtil;
@Service
public class AuthorityManageServiceImpl implements AuthorityManageService{

	@Autowired
	private FirstAuthorityMapper firstMapper;
	
	@Autowired
	private SecondAuthorityMapper secondMapper;
	
	@Autowired
	private ThirdlyAuthorityMapper thirdlyMapper;
	
	@Autowired
	private UserAuthorityMapper userAuthorityMapper;
	
	@Autowired
	private UserBugMapper bugMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private AgentMapper agentMapper;
	
	@Autowired
	private UorderMapper orderMapper;
	
	@Autowired
	private CommodityMapper comMapper;
	/**
	 * 获取所有权限
	 */
	@Override
	public Result getAllAuthority(String accountType) {
		Result result = new Result();
		try {
			FirstAuthorityExample firstExample = new FirstAuthorityExample();
			Criteria firstCriteria = firstExample.createCriteria();
			firstCriteria.andFirstAuthorityIdIsNotNull();
			if(accountType.equals("1")){
				firstCriteria.andFirstAuthorityIdNotLike("%7%");
				firstCriteria.andFirstAuthorityIdNotLike("%6%");
			}
			List<FirstAuthority> firstList = firstMapper.selectByExample(firstExample);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			
			for(int i=0;i<firstList.size();i++){
				Map<String,Object> firstMap = new HashMap<String, Object>();
				List<Map<String,Object>> listSecondMap = new ArrayList<Map<String,Object>>();
				firstMap.put("id", firstList.get(i).getFirstAuthorityId());
				firstMap.put("label", firstList.get(i).getFirstAuthorityName());
				//list.add(firstMap);
				SecondAuthorityExample secondExample = new SecondAuthorityExample();
				com.jade.mod.SecondAuthorityExample.Criteria secondCriteria = secondExample.createCriteria();
				secondCriteria.andBelongtoEqualTo(firstList.get(i).getFirstAuthorityId());
				if(accountType.equals("1")){
					secondCriteria.andSecondAuthorityIdNotLike("%7%");
					secondCriteria.andSecondAuthorityIdNotLike("%6%");
				}
				List<SecondAuthority> secondList = secondMapper.selectByExample(secondExample);
				
				for(int j=0;j<secondList.size();j++){
					List<Map<String,Object>> listThirdlyMap = new ArrayList<Map<String,Object>>();
					Map<String,Object> secondMap = new HashMap<String, Object>();
					secondMap.put("id", secondList.get(j).getSecondAuthorityId());
					secondMap.put("label", secondList.get(j).getSecondAuthorityName());
					
					ThirdlyAuthorityExample thirdlyExample = new ThirdlyAuthorityExample();
					com.jade.mod.ThirdlyAuthorityExample.Criteria thirdlyCriteria = thirdlyExample.createCriteria();
					List<String> belong = new ArrayList<String>();
					belong.add(secondList.get(j).getSecondAuthorityId());
					String str=(secondList.get(j).getSecondAuthorityId().toString()).substring(0,5)+"*";
					belong.add(str);
					thirdlyCriteria.andBelongtoIn(belong);
					List<ThirdlyAuthority> thirdlyList =thirdlyMapper.selectByExample(thirdlyExample);
					
					for(int a=0;a<thirdlyList.size();a++){
						Map<String,Object> tirdlyMap = new HashMap<String, Object>();
						tirdlyMap.put("id", thirdlyList.get(a).getThirdlyAuthorityId());
						tirdlyMap.put("label", thirdlyList.get(a).getThirdlyAuthorityName());
						
						listThirdlyMap.add(tirdlyMap);
					}
					secondMap.put("children", listThirdlyMap);
					listSecondMap.add(secondMap);
				}
				firstMap.put("children", listSecondMap);
				list.add(firstMap);
			}
			
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 权限分配
	 */
	@Override
	public Result authorityOfDistribution(JSONObject data,String account) {
		Result result = new Result();
		try {
			String roleId = data.getString("roleId");
			UserAuthorityExample example = new UserAuthorityExample();
			com.jade.mod.UserAuthorityExample.Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(roleId);
			userAuthorityMapper.deleteByExample(example);
		
			if(data.has("data")){
				String one = data.getString("data");
				String[] str = one.split(",");
				
				for(int i=0;i<str.length;i++){
					UserAuthority userAuthorityInsert = new UserAuthority();
					userAuthorityInsert.setUserAuthorityId(UuidUtil.get32UUID());
					userAuthorityInsert.setAuthorityId(str[i]);
					userAuthorityInsert.setAccount(roleId);
					userAuthorityInsert.setCreateTime(new Date());
					userAuthorityMapper.insertSelective(userAuthorityInsert);
				}
			}
			result.setSuccess(true);
			//result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 获取用户列表
	 */
	@Override
	public Result getUserList(JSONObject data,String account) {
		Result result = new Result();
		try {
			User userAccount =  userMapper.selectByPrimaryKey(account);
			Map<String,Object> map = new HashMap<String, Object>();
			if(userAccount.getAccounttype().equals("1")){
				//map.put("accountType", "2");
				map.put("sid", userAccount.getSid());
				List<Map<String,Object>> list = bugMapper.selectUserList(map);
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						if("1".equals(list.get(i).get("uComment").toString())){
							list.get(i).put("role", "用户账号");
						}
					}
				}
				result.setSuccess(true);
				result.getResult().put("data", list);
			}else{
				map.put("sid", userAccount.getSid());
				List<Map<String,Object>> list = bugMapper.selectUserList(map);
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						if("1".equals(list.get(i).get("uComment").toString())){
							list.get(i).put("role", "用户账号");
						}
					}
				}
				result.setSuccess(true);
				result.getResult().put("data", list);
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
	 * 删除账号
	 */
	@Override
	public Result DelUser(JSONObject data) {
		Result result = new Result();
		try {
			if(!data.getString("account").equals("jade001")){
				userMapper.deleteByPrimaryKey(data.getString("account"));
				bugMapper.deleteByPrimaryKey(data.getString("account"));
				result.setSuccess(true);
				result.getResult().put("data", "删除成功");
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
	 * 修改用户信息
	 */
	@Override
	public Result UpdateUser(JSONObject data) {
		Result result = new Result();
		try {
			String account = data.getString("account");
			System.out.println("*****"+account);
			
			User user = new User();
			UserBug userBug = new UserBug();
			user.setAccount(account);
			userBug.setAccount(account);
			if(data.has("uName")){
				user.setName(data.getString("uName"));
			}
			if(data.has("telephone")){
				user.setTelephone(data.getString("telephone"));
			}
			if(data.has("idNumber")){
				
				userBug.setIdNumber(data.getString("idNumber"));
			}
			if(!account.equals("jade001")){
				if(data.has("roleId")){
					String roleId = data.getString("roleId");
					user.setComment(roleId);
				}
			}
			
			if(data.has("password")){
				String pwd = new SimpleHash("SHA-1", account, data.getString("password")).toString();
				user.setPassword(pwd);
				userBug.setPassword(data.getString("password"));
			}
			bugMapper.updateByPrimaryKeySelective(userBug);
			userMapper.updateByPrimaryKeySelective(user);
			result.setSuccess(true);
			result.getResult().put("data", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 添加用户
	 */
	@Override
	public Result addManageUser(JSONObject data, String userId) {
		Result result = new Result();
		try {
			User userName = userMapper.selectByPrimaryKey(userId);
			UserBug userbug = bugMapper.selectByPrimaryKey(userId);
			SimpleDateFormat sdf=new SimpleDateFormat("ddHHmmss");
			String str2=sdf.format(new Date());
			java.util.Random random=new java.util.Random();
			String str1 = random.nextInt(10)+"";
			String account = data.getString("account");
			User userAccount =  userMapper.selectByPrimaryKey(account);
			if(userAccount==null){
				String password = data.getString("password");
				User user = new User();
				
				String name = data.getString("name");
				if(userName.getAccounttype().equals("1")){
					Agent agent = agentMapper.selectByPrimaryKey(userName.getSid());
					
					if(agent.getHaveNumber()>=agent.getUserNumber()){
						result.setSuccess(false);
						result.getResult().put("error", "您已经没有可以分配的用户数");
					}else if(agent.getHaveNumber()<agent.getUserNumber()){
						Agent agentNum = new Agent();
						agentNum.setSid(userName.getSid());
						agentNum.setHaveNumber(agent.getHaveNumber()+1);
						user.setAccounttype("2");
						user.setUsetype("1");
						String pwd = new SimpleHash("SHA-1", account, password).toString();
						user.setTelephone(data.getString("telephone"));
						user.setAccount(account);
						user.setSid(agent.getSid());
						user.setHeadimg("上传/20170816162058");
						user.setName(name);
						user.setCreatetime(new Date());
						user.setPassword(pwd);
						userMapper.insertSelective(user);
						UserBug userBug = new UserBug();
						userBug.setAccount(account);
						userBug.setPassword(password);
						userBug.setAddPerson(userName.getName());
						userBug.setCreateTime(new Date());
						userBug.setIdNumber(data.getString("idNumber"));
						bugMapper.insertSelective(userBug);
						agentMapper.updateByPrimaryKeySelective(agentNum);
						result.setSuccess(true);
						result.getResult().put("success", "添加成功");
					}
					
				}else{
					if(data.has("roleId")){
						String comment = data.getString("roleId");
						user.setAccounttype("0");
						user.setComment(comment);
						user.setUsetype("1");
					}else{
						user.setUsetype("0");
					}
					String pwd = new SimpleHash("SHA-1", account, password).toString();
					user.setTelephone(data.getString("telephone"));
					user.setAccount(account);
					user.setSid(userName.getSid());
					user.setHeadimg("上传/20170816162058");
					user.setName(name);
					user.setCreatetime(new Date());
					user.setPassword(pwd);
					userMapper.insertSelective(user);
					UserBug userBug = new UserBug();
					userBug.setAccount(account);
					userBug.setPassword(password);
					userBug.setAddPerson(userName.getName());
					userBug.setCreateTime(new Date());
					if(userbug!=null){
						userBug.setIdNumber(data.getString("idNumber"));
					}else{
						userBug.setIdNumber(data.getString("idNumber"));
					}
					bugMapper.insertSelective(userBug);
					result.setSuccess(true);
					result.getResult().put("success", "添加成功");
				}
				
				
				
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "账号已存在");
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
	 * 添加用户
	 */
	@Override
	public Result addUser(JSONObject data, String userId) {
		Result result = new Result();
		try {
			User userName = userMapper.selectByPrimaryKey(userId);
			UserBug userbug = bugMapper.selectByPrimaryKey(userId);
			SimpleDateFormat sdf=new SimpleDateFormat("ddHHmmss");
			String str2=sdf.format(new Date());
			java.util.Random random=new java.util.Random();
			String str1 = random.nextInt(10)+"";
			String account = data.getString("account");
			User userAccount =  userMapper.selectByPrimaryKey(account);
			if(userAccount==null){
				String password = data.getString("password");
				User user = new User();
				String name = data.getString("name");
				String idNumber = data.getString("idNumber");
				if(userName.getAccounttype().equals("1")){
					Agent agent = agentMapper.selectByPrimaryKey(userName.getSid());
					if(agent.getHaveNumber()>=agent.getUserNumber()){
						result.setSuccess(false);
						result.getResult().put("error", "您已经没有可以分配的用户数");
					}else if(agent.getHaveNumber()<agent.getUserNumber()){
						if(data.has("roleId")){
							if(data.getString("roleId").equals("1")){
								String comment = data.getString("roleId");
								user.setAccounttype("2");
								user.setComment(comment);
								user.setUsetype("1");
							}else{
								String comment = data.getString("roleId");
								user.setAccounttype("0");
								user.setComment(comment);
								user.setUsetype("1");
							}
						}else{
							user.setUsetype("0");
						}
						Agent agentNum = new Agent();
						agentNum.setSid(userName.getSid());
						agentNum.setHaveNumber(agent.getHaveNumber()+1);
						
						String pwd = new SimpleHash("SHA-1", account, password).toString();
						user.setTelephone(agent.getTelephone());
						user.setAccount(account);
						user.setSid(agent.getSid());
						user.setHeadimg("上传/20170816162058");
						user.setName(name);
						user.setCreatetime(new Date());
						user.setPassword(pwd);
						userMapper.insertSelective(user);
						UserBug userBug = new UserBug();
						userBug.setAccount(account);
						userBug.setPassword(password);
						userBug.setAddPerson(userName.getName());
						userBug.setCreateTime(new Date());
						userBug.setIdNumber(idNumber);
						bugMapper.insertSelective(userBug);
						agentMapper.updateByPrimaryKeySelective(agentNum);
						result.setSuccess(true);
						result.getResult().put("success", "添加成功");
					}
				}else{
					if(data.has("roleId")){
						if(data.getString("roleId").equals("1")){
							String comment = data.getString("roleId");
							user.setAccounttype("2");
							user.setComment(comment);
							user.setUsetype("1");
						}else{
							String comment = data.getString("roleId");
							user.setAccounttype("0");
							user.setComment(comment);
							user.setUsetype("1");
						}
					}else{
						user.setUsetype("0");
					}
					String pwd = new SimpleHash("SHA-1", account, password).toString();
					user.setTelephone(data.getString("telephone"));
					user.setAccount(account);
					user.setSid(userName.getSid());
					user.setHeadimg("上传/20170816162058");
					user.setName(name);
					user.setCreatetime(new Date());
					user.setPassword(pwd);
					userMapper.insertSelective(user);
					UserBug userBug = new UserBug();
					userBug.setAccount(account);
					userBug.setPassword(password);
					userBug.setIdNumber(idNumber);
					userBug.setAddPerson(userName.getName());
					userBug.setCreateTime(new Date());
					
					bugMapper.insertSelective(userBug);
					result.setSuccess(true);
					result.getResult().put("success", "添加成功");
				}
				
				
				
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "账号已存在");
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
	 * 获取角色列表
	 */
	@Override
	public Result getRoleList(String sid) {
		Result result = new Result();
		try {
			
			RoleExample example = new RoleExample();
			com.jade.mod.RoleExample.Criteria criteria = example.createCriteria();
			criteria.andReserve1EqualTo(sid);
			criteria.andRoleIdIsNotNull();
			List<Role> list = roleMapper.selectByExample(example);
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 修改角色
	 */
	@Override
	public Result updateRole(JSONObject data) {
		Result result = new Result();
		try {
			Role role = new Role();
			
			
				String roleId = data.getString("roleId");
				role.setRoleId(roleId);
			
			
			if(data.has("roleName")){
				String roleName = data.getString("roleName");
				role.setRoleName(roleName);
			}
			
			if(data.has("comment")){
				String comment = data.getString("comment");
				role.setComment(comment);
			}
			
			roleMapper.updateByPrimaryKeySelective(role);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 添加角色
	 */
	@Override
	public Result addRole(JSONObject data, String account,String sid) {
		Result result = new Result();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("ddHHmmss");
			String str2=sdf.format(new Date());
			java.util.Random random=new java.util.Random();
			String str1 = random.nextInt(10)+"";
			
			Role role = new Role();
			String roleName = data.getString("roleName");
			if(data.has("comment")){
				String comment = data.getString("comment");
				role.setComment(comment);
			}
			User userName = userMapper.selectByPrimaryKey(account);
			role.setRoleId("yckj"+str1+str2);
			role.setRoleName(roleName);
			role.setAddPerson(userName.getName());
			role.setCreateTime(new Date());
			role.setReserve1(sid);
			roleMapper.insertSelective(role);
			if(data.has("data")){//权限
				String one = data.getString("data");
				String[] str = one.split(",");
				
				for(int i=0;i<str.length;i++){
					UserAuthority userAuthorityInsert = new UserAuthority();
					userAuthorityInsert.setUserAuthorityId(UuidUtil.get32UUID());
					userAuthorityInsert.setAuthorityId(str[i]);
					userAuthorityInsert.setAccount("yckj"+str1+str2);
					userAuthorityInsert.setCreateTime(new Date());
					userAuthorityMapper.insertSelective(userAuthorityInsert);
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 删除角色
	 */
	@Override
	public Result delRole(JSONObject data) {
		Result result = new Result();
		try {
			String roleId = data.getString("roleId");
			roleMapper.deleteByPrimaryKey(roleId);
			UserExample example = new UserExample();
			com.jade.mod.UserExample.Criteria criteria = example.createCriteria();
			criteria.andCommentEqualTo(roleId);
			List<User> list = userMapper.selectByExample(example);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					User user = list.get(i);
					User delUser = new User();
					delUser.setAccount(user.getAccount());
					delUser.setComment("");
					delUser.setUsetype("0");
					userMapper.updateByPrimaryKeySelective(delUser);
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 获取角色权限
	 */
	@Override
	public Result getRoleAuthority(JSONObject data) {
		Result result = new Result();
		try {
			String roleId = data.getString("roleId");
			
			List<String> list = userAuthorityMapper.selectAuthorityId(roleId);
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 获取用户业绩
	 * @param account
	 * @return
	 */
	@Override
	public Result getUserPerformance(JSONObject data) {
		Result result = new Result();
		try {
			UorderExample example = new UorderExample();
			com.jade.mod.UorderExample.Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(data.getString("account"));
			List<String> list = new ArrayList<String>();
			list.add("3");
			list.add("0");
			criteria.andTypeIn(list);
			if(data.has("startDate")&&data.has("endDate")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				criteria.andEndTimeBetween(format.parse(data.getString("startDate")), format.parse(data.getString("endDate")));
			}
			List<Uorder> orders = orderMapper.selectByExample(example);
			int totalPrice = 0;
			int totalNum = 0;
			List<Commodity> com = new ArrayList<Commodity>();
			if(orders.size()>0){
				totalNum = orders.size();
				for(Uorder order:orders){
					Commodity commodity = comMapper.selectByPrimaryKey(order.getCid());
					if(commodity!=null){
						com.add(commodity);
					}
					totalPrice = totalPrice+comMapper.selectByPrimaryKey(order.getCid()).getPrice();
				}
			}
			
			result.setSuccess(true);
			result.getResult().put("totalPrice", totalPrice);
			result.getResult().put("totalNum", totalNum);
			result.getResult().put("commodity", com);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	

}
