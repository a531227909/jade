package com.jade.manage.service;

import com.jade.po.Result;

import net.sf.json.JSONObject;

public interface PerformanceService {
	//查询代理商业绩
	public Result agentPerformance(JSONObject data);
	//清空代理商业绩
	public Result delagentPerformance(JSONObject data);
}
