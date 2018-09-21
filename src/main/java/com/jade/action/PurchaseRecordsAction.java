package com.jade.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.PurchaseRecordsService;

@Controller
@RequestMapping(value="purchaseRecords")
public class PurchaseRecordsAction {

	@Autowired
	private PurchaseRecordsService purchaseRecordsService;
	/**
	 * 根据用户账号查询所有购物信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/selectPurchaseRecords.action",method=RequestMethod.POST)
	public @ResponseBody Result selectPurchaseRecords(HttpSession session,int page) {
		String account = (String) session.getAttribute("account");
		return purchaseRecordsService.selectPurchaseRecords(account,page);
		
	}
}
