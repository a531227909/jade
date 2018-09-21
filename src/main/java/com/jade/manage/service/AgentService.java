package com.jade.manage.service;

import com.jade.po.Result;

import net.sf.json.JSONObject;

public interface AgentService {

	/**
	 * 添加代理商
	 * @param data
	 * @return
	 */
	public Result addAgent(JSONObject data,String userId);
	/**
	 * 更新代理商
	 * @param data
	 * @return
	 */
	public Result updateAgent(JSONObject data);
	/**
	 * 根据sid获取代理商信息
	 * @param data
	 * @return
	 */
	public Result getAgentBySid(JSONObject data);
	/**
	 * 注销代理商(代理商相关账号，商品都停用)
	 * @param data
	 * @return
	 */
	public Result cancelAgent(JSONObject data);
	/**
	 * 激活代理商(商品需重新上架，账号自动激活)
	 * @param data
	 * @return
	 */
	public Result activationAgent(JSONObject data);
	/**
	 * 删除代理商(先注销才可删除)
	 * @param data
	 * @return
	 */
	public Result delAgent(JSONObject data);
	/**
	 * 根据sid查询代理商业绩
	 * @param data
	 * @return
	 */
	public Result agentPerformance(JSONObject data);
	/**
	 * 设置代理商用户数上限
	 * @param data
	 * @return
	 */
	public Result setUserNumber(JSONObject data);
	/**
	 * 获取代理商下的所有用户账号
	 * @param data
	 * @return
	 */
	public Result getUserMessage(JSONObject data);
	/**
	 * 查询所有代理商
	 * @param data
	 * @return
	 */
	public Result selectAgent(JSONObject data);
	/**
	 * 根据代理商名模糊查询
	 * @param data
	 * @return
	 */
	public Result selectAgentByLike(JSONObject data);
	
	/**
	 * 添加代理商账号
	 */
	public Result addAgentAccount(JSONObject data,String account1);
}
