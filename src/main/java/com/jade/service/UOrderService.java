package com.jade.service;

import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface UOrderService {

	public Result insertOrder(JSONObject data,String account);
	
	public Result selectOrderByType(String type,String account,int page);
	
	public Result delOrder(String orderId,String account);
	
	public Result selectByOrderId(String orderId);
	
	public Result insertOrderByCart(JSONObject data,String account);

	public Result updateOrder(String orderId,String type,String account);
}
