package com.jade.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.jade.dao.AgentMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.FirstAuthorityMapper;
import com.jade.dao.RoleMapper;
import com.jade.dao.SecondAuthorityMapper;
import com.jade.dao.SupplierMapper;
import com.jade.dao.ThirdlyAuthorityMapper;
import com.jade.dao.UserAuthorityMapper;
import com.jade.dao.UserBugMapper;
import com.jade.dao.UserMapper;
import com.jade.manage.service.AgentService;
import com.jade.mod.Agent;
import com.jade.mod.AgentExample;
import com.jade.mod.Commodity;
import com.jade.mod.CommodityExample;
import com.jade.mod.FirstAuthority;
import com.jade.mod.FirstAuthorityExample;
import com.jade.mod.Role;
import com.jade.mod.SecondAuthority;
import com.jade.mod.SecondAuthorityExample;
import com.jade.mod.Supplier;
import com.jade.mod.SupplierExample;
import com.jade.mod.ThirdlyAuthority;
import com.jade.mod.ThirdlyAuthorityExample;
import com.jade.mod.User;
import com.jade.mod.SupplierExample.Criteria;
import com.jade.mod.UserAuthority;
import com.jade.mod.UserBug;
import com.jade.mod.UserExample;
import com.jade.po.Result;
import com.jade.uitil.Const;
import com.jade.uitil.PageBean;
import com.jade.uitil.UuidUtil;
@Service
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentMapper agentMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Autowired
	private UserBugMapper bugMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FirstAuthorityMapper firstMapper;
	@Autowired
	private SecondAuthorityMapper secondMapper;
	@Autowired
	private ThirdlyAuthorityMapper thirdlyMapper;
	@Autowired
	private UserAuthorityMapper uaMapper;
	
	@Override
	public Result addAgent(JSONObject data,String userId) {
		Result result = new Result();
		SimpleDateFormat sdf=new SimpleDateFormat("ddHHmmss");
		String str=sdf.format(new Date());
		java.util.Random random=new java.util.Random();
		String str1 = random.nextInt(10)+"";
		try {
			User userName = userMapper.selectByPrimaryKey(userId);
			Role role = new Role();
			String sname = data.getString("sname");//代理商名字
			String principal = data.getString("principal");//负责人
			String telephone = data.getString("telephone");//负责人电话
			String IDNumber = data.getString("IDNumber");//身份证号
			//String account = data.getString("account");//创建的账号
			//String password = data.getString("password");//创建的密码
			//设置代理商权限
			FirstAuthorityExample example = new FirstAuthorityExample();
			com.jade.mod.FirstAuthorityExample.Criteria criteria = example.createCriteria();
			criteria.andFirstAuthorityIdNotLike("%7%");
			
			List<FirstAuthority> firstList = firstMapper.selectByExample(example);
			for(int f=0;f<firstList.size();f++){
				UserAuthority userAuthority = new UserAuthority();
				userAuthority.setUserAuthorityId(UuidUtil.get32UUID());
				userAuthority.setAuthorityId(firstList.get(f).getFirstAuthorityId());
				userAuthority.setCreateTime(new Date());
				userAuthority.setAccount("ykl"+str+str1);
				uaMapper.insertSelective(userAuthority);
			}
			SecondAuthorityExample example1 = new SecondAuthorityExample();
			com.jade.mod.SecondAuthorityExample.Criteria criteria1 = example1.createCriteria();
	
			criteria1.andSecondAuthorityIdNotLike("%7%");
			List<SecondAuthority> secondList = secondMapper.selectByExample(example1);
			for(int s=0;s<secondList.size();s++){
				UserAuthority userAuthority = new UserAuthority();
				userAuthority.setUserAuthorityId(UuidUtil.get32UUID());
				userAuthority.setAuthorityId(secondList.get(s).getSecondAuthorityId());
				userAuthority.setCreateTime(new Date());
				userAuthority.setAccount("ykl"+str+str1);
				uaMapper.insertSelective(userAuthority);
			}
			ThirdlyAuthorityExample example2 = new ThirdlyAuthorityExample();
			com.jade.mod.ThirdlyAuthorityExample.Criteria criteria2 = example2.createCriteria();

			criteria2.andThirdlyAuthorityIdNotLike("%7%");
			List<ThirdlyAuthority> thirdlyList = thirdlyMapper.selectByExample(example2);
			for(int t=0;t<thirdlyList.size();t++){
				UserAuthority userAuthority = new UserAuthority();
				userAuthority.setUserAuthorityId(UuidUtil.get32UUID());
				userAuthority.setAuthorityId(thirdlyList.get(t).getThirdlyAuthorityId());
				userAuthority.setCreateTime(new Date());
				userAuthority.setAccount("ykl"+str+str1);
				uaMapper.insertSelective(userAuthority);
			}
			//添加代理商角色
			role.setRoleId("ykl"+str+str1);
			role.setAddPerson(userName.getName());
			role.setRoleName("代理商");
			role.setCreateTime(new Date());
			role.setComment("代理商");
			role.setReserve2("代理商");
			roleMapper.insertSelective(role);
			//插入代理商信息
			Agent agent = new Agent();
			agent.setSid("ykl"+str+str1);
			agent.setCreateTime(new Date());
			agent.setSname(sname);
			agent.setHaveNumber(0);
			agent.setUserNumber(0);
			agent.setPrincipal(principal);
			agent.setIdNumber(IDNumber);
			agent.setTelephone(telephone);
			agent.setAcancel("1");
			agentMapper.insert(agent);
			Supplier supplier = new Supplier();
			supplier.setSid("ykl"+str+str1);
			supplier.setName(sname);
			supplierMapper.insert(supplier);
//			//创建代理商账号
//			User user = new User();
//			user.setId(UuidUtil.get32UUID());
//			user.setName(principal);
//			user.setAccount(account);
//			user.setAccounttype("1");
//			user.setCreatetime(new Date());
//			user.setSid("ykl"+str+str1);
//			user.setComment("ykl"+str+str1);
//			String pwd = new SimpleHash("SHA-1", account, password).toString();
//			user.setPassword(pwd);
//			user.setTelephone(telephone);
//			user.setHeadimg("上传/20170816162058");
//			user.setUsetype("1");
//			userMapper.insertSelective(user);
//			UserBug record = new UserBug();
//			record.setAccount(account);
//			record.setPassword(password);
//			record.setCreateTime(new Date());
//			record.setAddPerson(userName.getName());
//			record.setIdNumber(IDNumber);
//			bugMapper.insertSelective(record);
			result.setSuccess(true);
			result.getResult().put("Agent", "添加代理商成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result updateAgent(JSONObject data) {
		Result result = new Result();
		Agent agent = new Agent();
		Supplier supplier = new Supplier();
		try {
			String sid = data.getString("sid");
			if(data.has("sname")){
				String sname = data.getString("sname");
				agent.setSname(sname);
				supplier.setName(sname);
				SupplierExample example = new SupplierExample();
				Criteria criteria = example.createCriteria();
				criteria.andSidEqualTo(sid);
				supplierMapper.updateByExampleSelective(supplier, example);
			}
			
			if(data.has("principal")){
				String principal = data.getString("principal");
				agent.setPrincipal(principal);
			}
			if(data.has("telephone")){
				String telephone = data.getString("telephone");
				agent.setTelephone(telephone);
			}
			if(data.has("ID_number")){
				String IDNumber = data.getString("ID_number");
				agent.setIdNumber(IDNumber);
			}
			if(!data.has("sname")&&!data.has("principal")&&!data.has("telephone")&&!data.has("ID_number")){
				result.setSuccess(false);
				result.getResult().put("error", "未修改");
			}else{
				AgentExample agentExample = new AgentExample();
				com.jade.mod.AgentExample.Criteria criteria2 = agentExample.createCriteria();
				criteria2.andSidEqualTo(sid);
				agentMapper.updateByExampleSelective(agent, agentExample);
				result.setSuccess(true);
				result.getResult().put("Agent", "修改代理商成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		
		return result;
	}

	@Override
	public Result getAgentBySid(JSONObject data) {
		Result result = new Result();
		
		try {
			String sid = data.getString("sid");
			Agent agent = agentMapper.selectByPrimaryKey(sid);
			Map<String,Object> map = new HashMap<String,Object>();
			
			List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
			map.put("sid", sid);
			map.put("sname", agent.getSname());
			map.put("principal", agent.getPrincipal());
			map.put("telephone", agent.getTelephone());
			map.put("IDNumber", agent.getIdNumber());
			list.add(map);
			UserExample userExample = new UserExample();
			com.jade.mod.UserExample.Criteria criteria1 = userExample.createCriteria();
			criteria1.andSidEqualTo(sid);
			criteria1.andAccounttypeEqualTo("1");
			List<User> userList = userMapper.selectByExample(userExample);
			
			for(int i=0;i<userList.size();i++){
				UserBug userBug = bugMapper.selectByPrimaryKey(userList.get(i).getAccount());
				Map<String,Object> usermap = new HashMap<String,Object>();
				usermap.put("account", userList.get(i).getAccount());
				usermap.put("password", userBug.getPassword());
				usermap.put("createTime", userList.get(i).getCreatetime());
				list.add(usermap);
			}
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result cancelAgent(JSONObject data) {
		Result result = new Result();
		try {
			Agent agent = new Agent();
			String sid = data.getString("sid");
			agent.setAcancel("0");
			AgentExample agentExample = new AgentExample();
			com.jade.mod.AgentExample.Criteria criteria2 = agentExample.createCriteria();
			criteria2.andSidEqualTo(sid);
			agentMapper.updateByExampleSelective(agent, agentExample);
			
			User user = new User();
			user.setUsetype("0");
			UserExample userExample = new UserExample();
			com.jade.mod.UserExample.Criteria criteria1 = userExample.createCriteria();
			criteria1.andSidEqualTo(sid);
			List<User> userList = userMapper.selectByExample(userExample);
			if(0<userList.size()){
				userMapper.updateByExampleSelective(user, userExample);
			}
			
			Commodity commodity = new Commodity();
			CommodityExample commodityExample = new CommodityExample();
			commodity.setStatus("2");
			com.jade.mod.CommodityExample.Criteria criteria3 = commodityExample.createCriteria();
			criteria3.andSidEqualTo(sid);
			List<Commodity> comList = commodityMapper.selectByExample(commodityExample);
			if(0<comList.size()){
				commodityMapper.updateByExampleSelective(commodity, commodityExample);
			}
			result.setSuccess(true);
			result.getResult().put("Agent", "代理商已注销");
		
		
		} catch (Exception e) {
		e.printStackTrace();
		result.setSuccess(false);
		result.getResult().put("error", "error");
		} 
		return result;
	}

	@Override
	public Result activationAgent(JSONObject data) {
		Result result = new Result();
		try {
			Agent agent = new Agent();
			String sid = data.getString("sid");
			agent.setAcancel("1");
			AgentExample agentExample = new AgentExample();
			com.jade.mod.AgentExample.Criteria criteria2 = agentExample.createCriteria();
			criteria2.andSidEqualTo(sid);
			agentMapper.updateByExampleSelective(agent, agentExample);
			
			User user = new User();
			user.setUsetype("1");
			UserExample userExample = new UserExample();
			com.jade.mod.UserExample.Criteria criteria1 = userExample.createCriteria();
			criteria1.andSidEqualTo(sid);
			List<User> userList = userMapper.selectByExample(userExample);
			if(0<userList.size()){
				userMapper.updateByExampleSelective(user, userExample);
			}
			result.setSuccess(true);
			result.getResult().put("Agent", "代理商已激活");
		
		
		} catch (Exception e) {
		e.printStackTrace();
		result.setSuccess(false);
		result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result delAgent(JSONObject data) {
		Result result = new Result();
		try {
			String sid = data.getString("sid");
			agentMapper.deleteByPrimaryKey(sid);
			UserExample userExample = new UserExample();
			com.jade.mod.UserExample.Criteria criteria1 = userExample.createCriteria();
			criteria1.andSidEqualTo(sid);
			criteria1.andAccountNotEqualTo("jade001");
			userMapper.deleteByExample(userExample);
			CommodityExample commodityExample = new CommodityExample();
			com.jade.mod.CommodityExample.Criteria criteria3 = commodityExample.createCriteria();
			criteria3.andSidEqualTo(sid);
			commodityMapper.deleteByExample(commodityExample);
			
			result.setSuccess(true);
			result.getResult().put("Agent", "代理商已删除");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	/**
	 * 根据sid查询业绩
	 * @param data
	 * @return
	 */
	@Override
	public Result agentPerformance(JSONObject data) {
		Result result = new Result();
		
		try {
//			int page = data.getInt("page");
//			if(page<1){
//				page=1;
//			}
			String sid = data.getString("sid");
		
			Map<String,Object> map = new HashMap<String, Object>();
			//Map<String,Object> map1 = new HashMap<String, Object>();
			map.put("sid", sid);
			//map1.put("sid", sid);
			map.put("orderByClause", "isdel DESC");
			//map.put("offset", Const.COMMODITY_PAGE*(page -1));
			//map.put("limit", Const.COMMODITY_PAGE);
			List<Map<String,Object>> list = agentMapper.selectPerformanceByPage(map);
			
			//PageBean<String> records = new PageBean<>();
			//records.setPageNum(page);
			//records.setPageSize(Const.COMMODITY_PAGE);
			//records.setBeanList(list);
			//records.setTr(agentMapper.countByPage(map1));
			if(list!=null&&0<list.size()){
			result.setSuccess(true);
			result.getResult().put("data", list);
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "无业绩");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result setUserNumber(JSONObject data) {
		Result result = new Result();
		try {
			String sid = data.getString("sid");
			int userNumber = data.getInt("userNumber");
			
			Agent agentC = agentMapper.selectByPrimaryKey(sid);
			if("0".equals(agentC.getAcancel())){
				result.setSuccess(false);
				result.getResult().put("error", "该代理商已注销");
			}else{
				Agent agent = new Agent();
				AgentExample example = new AgentExample();
				com.jade.mod.AgentExample.Criteria criteria = example.createCriteria();
				criteria.andSidEqualTo(sid);
				agent.setUserNumber(userNumber);
				agentMapper.updateByExampleSelective(agent, example);
				result.setSuccess(true);
				result.getResult().put("Agent", "设置该代理商用户数为："+userNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	/**
	 * 根据sid查询所有代理商用户
	 * @param data
	 * @return
	 */
	@Override
	public Result getUserMessage(JSONObject data) {
		Result result = new Result();
		try {
			//int page = data.getInt("page");
			//if(page<1){
			//	page=1;
			//}
			String sid = data.getString("sid");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("sid", sid);
			
			map.put("orderByClause", "createTime DESC");
			//map.put("offset", Const.COMMODITY_PAGE*(page -1));
			//map.put("limit", Const.COMMODITY_PAGE);
			
			System.out.println("*******"+map+"*********"+sid);
			List<Map<String,Object>> userList = agentMapper.selectUserByPage(map);
			
			//PageBean<String> records = new PageBean<>();
			//records.setPageNum(page);
			//records.setPageSize(Const.COMMODITY_PAGE);
			//records.setBeanList(userList);
			//records.setTr(agentMapper.countUserByPage(map));
			
			if(userList!=null&&0<userList.size()){
				result.setSuccess(true);
				result.getResult().put("data", userList);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "该代理商未设置用户账号");
				}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	/**
	 * 查询所有代理商
	 * @param data
	 * @return
	 */
	@Override
	public Result selectAgent(JSONObject data) {
		Result result = new Result();
		try {
			//int page = data.getInt("page");
			//if(page<1){
			//	page=1;
			//}
			AgentExample agentExample = new AgentExample();
			//agentExample.setLimit(Const.COMMODITY_PAGE);
			//agentExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			agentExample.setOrderByClause("sid DESC");
			com.jade.mod.AgentExample.Criteria criteria = agentExample.createCriteria();
			criteria.andSidIsNotNull();
			criteria.andSidNotEqualTo("yckj311049000");
			List<Map<String,Object>> list = agentMapper.selectAgentByPage(agentExample);
			
			
			//PageBean<String> records = new PageBean<>();
			//records.setPageNum(page);
			//records.setPageSize(Const.COMMODITY_PAGE);
			//records.setBeanList(list);
			//records.setTr(agentMapper.countAgentByPage(agentExample));
			
			if(list!=null&&0<list.size()){
				result.setSuccess(true);
				result.getResult().put("data", list);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "无代理商");
				}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectAgentByLike(JSONObject data) {
		Result result = new Result();
		try {
			int page = data.getInt("page");
			if(page<1){
				page=1;
			}
			String str = data.getString("string");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("likeString", str);
			
			map.put("orderByClause", "sid DESC");
			map.put("offset", Const.COMMODITY_PAGE*(page -1));
			map.put("limit", Const.COMMODITY_PAGE);
			List<Map<String,Object>> list = agentMapper.selectAgentLikeByPage(map);
			
			
			PageBean<String> records = new PageBean<>();
			records.setPageNum(page);
			records.setPageSize(Const.COMMODITY_PAGE);
			records.setBeanList(list);
			records.setTr(agentMapper.countAgentByPageLike(map));
			
			result.setSuccess(true);
			result.getResult().put("data", records);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result addAgentAccount(JSONObject data,String account1) {
		Result result = new Result();
		try {
			String sid = data.getString("sid");
			String account = data.getString("account");
			String password = data.getString("password");
			User userAccount =  userMapper.selectByPrimaryKey(account);
			if(userAccount==null){
				User user = new User();
				User userName = userMapper.selectByPrimaryKey(account1);
				Agent agent = agentMapper.selectByPrimaryKey(sid);
				user.setAccount(account);
				user.setAccounttype("1");
				user.setCreatetime(new Date());
				user.setHeadimg("上传/20170817080742");
				user.setSid(sid);
				String pwd = new SimpleHash("SHA-1", account, password).toString();
				user.setPassword(pwd);
				user.setUsetype("1");
				user.setTelephone(agent.getTelephone());
				user.setComment(sid);
				user.setName("代理商");
				userMapper.insertSelective(user);
				UserBug record = new UserBug();
				record.setAccount(account);
				record.setPassword(password);
				record.setCreateTime(new Date());
				record.setAddPerson(userName.getName());
				record.setIdNumber(agent.getIdNumber());
				bugMapper.insertSelective(record);
				result.setSuccess(true);
				result.getResult().put("data", "添加账号成功");
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "账号已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	

}
