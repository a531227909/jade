package com.jade.manage.service;


import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface UOrderManageService {
	/**
	 * 退单
	 * @param data
	 * @return
	 */
	public Result returnedUOrder(JSONObject data);
	/**
	 * 查看某代理商的所有订单
	 * @param data
	 * @return
	 */
	public Result getMyAllUOrder(JSONObject data,String account);
	/**
	 * 查看订单（含收货地址，商品详情）
	 */
	public Result checkComAndRec(JSONObject data);
	
	/**
	 * 改变订单状态（待收货，待发货等）
	 */
	public Result changeUOrderType(JSONObject data);
	/**
	 * 恢复订单
	 * @param data
	 * @return
	 */
	public Result restoreUOrder(JSONObject data);
	
}
