package com.jade.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.OrderStatisticsService;
import com.jade.po.Result;

@Controller
@RequestMapping("/OrderStatistics")
public class OrderStatisticsAction {

	@Autowired
	private OrderStatisticsService orderStatisticsService;
	
	/**
	 * 获取用户订单列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/selectOrderByDate.action",method=RequestMethod.POST)
	public @ResponseBody Result selectOrderByDate(String account, String startTime, String endTime, String page){
		return orderStatisticsService.selectOrderByDate(account, startTime, endTime, page);
	}
	
}
