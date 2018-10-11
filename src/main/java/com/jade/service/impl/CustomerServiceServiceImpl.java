package com.jade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CustomerServiceMapper;
import com.jade.mod.CustomerService;
import com.jade.po.Result;
import com.jade.service.CustomerServiceService;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService{

	@Autowired
	private CustomerServiceMapper customerServiceMapper;
	
	@Override
	public Result selectCustomerService(String account) {
		Result result = new Result();
		List<CustomerService> customerServices = customerServiceMapper.selectByAccount(account);
		result.setSuccess(true);
		result.getResult().put("data", customerServices);
		return result;
	}
	
	@Override
	public Result getCustomerService(String account) {
		Result result = new Result();
		List<CustomerService> customerServices = customerServiceMapper.selectByAccount(account);
		customerServiceMapper.updateIsRead("1", account);
		result.setSuccess(true);
		result.getResult().put("data", customerServices);
		return result;
	}
	
	@Override
	public Result insertCustomerService(String account, String content) {
		Result result = new Result();
		CustomerService customerService = new CustomerService();
		customerService.setAccount(account);
		customerService.setContent(content);
		//0未读
		customerService.setIs_read("0");
		int i = customerServiceMapper.insert(customerService);
		if(i==1){
			result.setSuccess(true);
			result.getResult().put("CustomerService", "新增客服信息成功");
		}else{
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	
}
