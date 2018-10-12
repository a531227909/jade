package com.jade.service;

import com.jade.po.Result;

public interface CustomerServiceService {

	public Result selectCustomerService(String account);
	
	public Result getCustomerService(String account);
	
	public Result insertCustomerService(String account, String phone, String name, String content);
	
	public Result replyCustomerService(String account, String customerService, String content);
	
}
