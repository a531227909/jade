package com.jade.manage.service;

import com.jade.po.Result;

public interface OrderStatisticsService {
	
	public Result selectOrderByDate(String account, String startTime, String endTime, String page);
	
}
