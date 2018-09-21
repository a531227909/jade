package com.jade.service;

import com.jade.po.Result;

public interface EvaluateService {

	public Result selectEvaluate(String cid,int page);
	
	public Result writeEvaluate(String account,String cid,String uEvaluate,String orderId);
}
