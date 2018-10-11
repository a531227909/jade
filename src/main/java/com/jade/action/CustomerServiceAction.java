package com.jade.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.CustomerServiceService;

@Controller
@RequestMapping(value="customerService")
public class CustomerServiceAction {

	@Autowired
	private CustomerServiceService customerServiceService;
	/**
	 * 根据用户账号查询所有客服聊天信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/selectCustomerService.action",method=RequestMethod.POST)
	public @ResponseBody Result selectCustomerService(HttpSession session) {
		String account = (String) session.getAttribute("account");
		return customerServiceService.selectCustomerService(account);
	}
	
	/**
	 * 根据用户账号查询所有客服聊天信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/selectCustomerServiceByAccount.action",method=RequestMethod.POST)
	public @ResponseBody Result selectCustomerServiceByAccount(String account, HttpSession session) {
		return customerServiceService.selectCustomerService(account);
	}
	
	/**
	 * 客服根据用户账号查询所有用户聊天信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/getCustomerService.action",method=RequestMethod.POST)
	public @ResponseBody Result selectAllCustomerServiceByAccount(String account, HttpSession session) {
		return customerServiceService.getCustomerService(account);
	}
	
	/**
	 * 添加客服聊天信息
	 * @param account
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/insertCustomerService.action",method=RequestMethod.POST)
	public @ResponseBody Result insertCustomerService(String content, HttpSession session) {
		String account = (String) session.getAttribute("account");
		return customerServiceService.insertCustomerService(account, content);
	}
}
