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
	public @ResponseBody Result insertCustomerService(String content, String phone, String name, HttpSession session) {
		String account = (String) session.getAttribute("account");
		return customerServiceService.insertCustomerService(account, phone, name, content);
	}
	
	/**
	 * 添加客服回复信息
	 * @param account
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/replyCustomerService.action",method=RequestMethod.POST)
	public @ResponseBody Result replyCustomerService(String account, String content, HttpSession session) {
		String customerService = (String) session.getAttribute("account");
		return customerServiceService.replyCustomerService(account, customerService, content);
	}
	
	/**
	 * 客服根据用户账号查询所有用户客服状态
	 * @param account
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/selectLastByAccount.action",method=RequestMethod.POST)
	public @ResponseBody Result selectLastByAccount(String account, String is_read, String page) {
		return customerServiceService.selectLastByAccount(account, is_read, page);
	}
	
}
