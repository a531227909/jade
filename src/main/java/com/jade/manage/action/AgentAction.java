package com.jade.manage.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.AgentService;
import com.jade.manage.service.PerformanceService;
import com.jade.po.Result;

@Controller
@RequestMapping("/agent")
public class AgentAction {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private PerformanceService performanceService;
	/**
	 * 添加代理商
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result addAgent(@RequestBody JSONObject data,HttpSession session){
		String userId = (String) session.getAttribute("account");
		return agentService.addAgent(data,userId);
		
	}
	/**
	 * 更新代理商
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result updateAgent(@RequestBody JSONObject data){
		
		return agentService.updateAgent(data);
		
	}
	/**
	 * 根据sid获取代理商信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/getAgentBySid.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result getAgentBySid(@RequestBody JSONObject data){
		
		return agentService.getAgentBySid(data);
		
	}
	/**
	 * 根据sid注销代理商(同时将账号，商品下架)
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/cancelAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result cancelAgent(@RequestBody JSONObject data){
		
		return agentService.cancelAgent(data);
		
	}
	/**
	 * 根据sid激活代理商(同时将账号激活，商品需手动上架)
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/activationAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result activationAgent(@RequestBody JSONObject data){
		
		return agentService.activationAgent(data);
		
	}
	/**
	 * 根据sid删除代理商(同时将账号，商品删除，代理商需先注销才可删除)
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/delAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result delAgent(@RequestBody JSONObject data){
		
		return agentService.delAgent(data);
		
	}
	/**
	 * 根据sid查询业绩
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/agentPerformance.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result agentPerformance(@RequestBody JSONObject data){
		
		return performanceService.agentPerformance(data);
		
	}
	/**
	 * 根据时间段删除业绩
	 */
	@RequestMapping(value="/delagentPerformance.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result delagentPerformance(@RequestBody JSONObject data){
		
		return performanceService.delagentPerformance(data);
		
	}
	/**
	 * 根据sid设置代理商用户数量
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/setUserNumber.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result setUserNumber(@RequestBody JSONObject data){
		
		return agentService.setUserNumber(data);
		
	}
	/**
	 * 根据sid查询所有代理商用户
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/getUserMessage.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result getUserMessage(@RequestBody JSONObject data){
		
		return agentService.getUserMessage(data);
		
	}
	/**
	 * 查询所有代理商
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/selectAgent.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result selectAgent(@RequestBody JSONObject data){
		
		return agentService.selectAgent(data);
		
	}
	/**
	 * 根据代理商名模糊查询
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/selectAgentByLike.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result selectAgentByLike(@RequestBody JSONObject data){
		
		return agentService.selectAgentByLike(data);
		
	}
	/**
	 * 根据代理商ID添加代理商账号
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addAgentAccount.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result addAgentAccount(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return agentService.addAgentAccount(data,account);
		
	}
}
