package com.jade.manage.service;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.jade.po.Result;

public interface ExpressService {

	/**
	 * 插入快递单号
	 * @param data
	 * @return
	 */
	public Result insertExpress(JSONObject data);

}
