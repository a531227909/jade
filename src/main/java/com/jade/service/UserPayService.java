package com.jade.service;

import com.jade.po.Result;

import net.sf.json.JSONObject;

public interface UserPayService {

	public Result pay(JSONObject data,String account);
	
}
