package com.jade.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.OrderStatisticsMapper;
import com.jade.manage.service.OrderStatisticsService;
import com.jade.mod.Uorder;
import com.jade.po.Result;

@Service
public class OrderStatisticsServiceImpl implements OrderStatisticsService{
	
	@Autowired
	private OrderStatisticsMapper orderStatisticsMapper;
	
	/*
	 * 分页数据量（每页多少数据）
	 */
	final static String pageSize = "10";

	@Override
	public Result selectOrderByDate(String account, String startTime, String endTime, String page) {
		Result result = new Result();
		String pageAmount = String.valueOf((Integer.parseInt(page)-1)*Integer.parseInt(pageSize));
		List<Uorder> uorders = orderStatisticsMapper.selectOrderStatisticsByDate(account, startTime, endTime, pageAmount, pageSize);
		int allCount = orderStatisticsMapper.selectOrderCount(account, startTime, endTime);
		float num = (allCount-1)/Integer.parseInt(pageSize)+1;
		result.setSuccess(true);
		result.getResult().put("totalData", allCount);
		result.getResult().put("data", uorders);
		result.getResult().put("pages", Integer.toString((int) Math.floor(num)));
		return result;
	}

}
