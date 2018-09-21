package com.jade.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.jade.dao.ExpressMapper;
import com.jade.manage.service.ExpressService;
import com.jade.mod.Express;
import com.jade.po.Result;
@Service
public class ExpressServiceImpl implements ExpressService{

	@Autowired
	private ExpressMapper expressService;
	
	@Override
	public Result insertExpress(JSONObject data) {
		Result result = new Result();
		try {
			String expressId = data.getString("expressId");
			String expressCompany = data.getString("expressCompany");
			String orderId = data.getString("orderId");
			Express express = new Express();
			express.setExpressCompany(expressCompany);
			express.setExpressId(expressId);
			express.setOrderId(orderId);
			expressService.insertSelective(express);
			result.setSuccess(true);
		} catch (Exception e) {
			
			result.setSuccess(false);
			result.getResult().put("error", "error");
			return result;
		}
		return result;
	}



}
