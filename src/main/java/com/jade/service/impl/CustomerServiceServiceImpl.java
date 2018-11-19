package com.jade.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CustomerServiceMapper;
import com.jade.mod.CustomerInformation;
import com.jade.mod.CustomerService;
import com.jade.po.Result;
import com.jade.service.CustomerServiceService;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService{

	@Autowired
	private CustomerServiceMapper customerServiceMapper;
	
	/*
	 * 分页数据量（每页多少数据）
	 */
	final static String pageSize = "10";
	
	@Override
	public Result selectCustomerService(String account) {
		Result result = new Result();
		List<CustomerService> customerServices = customerServiceMapper.selectByAccount(account);
		customerServiceMapper.updateReplyIsRead("0", account);
		result.setSuccess(true);
		result.getResult().put("data", customerServices);
		return result;
	}
	
	@Override
	public Result getCustomerService(String account) {
		Result result = new Result();
		List<CustomerService> customerServices = customerServiceMapper.selectByAccount(account);
		if(StringUtils.isNotBlank(account)){
			customerServiceMapper.updateIsRead("0", account);
		}
		result.setSuccess(true);
		result.getResult().put("data", customerServices);
		return result;
	}
	
	@Override
	public Result insertCustomerService(String account, String phone, String name, String content) {
		Result result = new Result();
		
		if(StringUtils.isNotBlank(phone)&&StringUtils.isNotBlank(name)){
			CustomerInformation ci = customerServiceMapper.selectCustomerInformation(account);
			if(ci==null||ci.equals("")){
				CustomerInformation customerInformation = new CustomerInformation();
				customerInformation.setAccount(account);
				customerInformation.setPhone(phone);
				customerInformation.setName(name);
				customerServiceMapper.insertCustomerInformation(customerInformation);
			}else{
				customerServiceMapper.updateCustomerInformation(account, phone, name);
			}
		}
		CustomerService customerService = new CustomerService();
		customerService.setAccount(account);
		customerService.setContent(content);
		//0已读，1未读
		customerService.setIs_read("1");
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

	@Override
	public Result replyCustomerService(String account, String customerService, String content) {
		Result result = new Result();
		CustomerService customer_service = new CustomerService();
		customer_service.setAccount(account);
		customer_service.setCustomer_service(customerService);
		customer_service.setContent(content);
		//0已读，1未读
		customer_service.setIs_read("1");
		int i = customerServiceMapper.insert(customer_service);
		if(i==1){
			result.setSuccess(true);
			result.getResult().put("CustomerService", "新增客服信息成功");
		}else{
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectLastByAccount(String account, String is_read, String page) {
		Result result = new Result();
		String pageAmount = String.valueOf((Integer.parseInt(page)-1)*Integer.parseInt(pageSize));
		List<CustomerService> customerServices = customerServiceMapper.selectLastByAccount(account, is_read, pageAmount, pageSize);
		int allCount = customerServiceMapper.selectLastByAccountCount(account, is_read);
		result.setSuccess(true);
		result.getResult().put("data", customerServices);
		result.getResult().put("totalData", allCount);
		result.getResult().put("pages", String.valueOf(allCount/Integer.parseInt(pageSize)+1));
		return result;
	}
	
}
