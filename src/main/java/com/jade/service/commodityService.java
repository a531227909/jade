package com.jade.service;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface commodityService {

	public Result getCommodityByCId(String cid,String account);
	
	public Result getFourOrByCategoryId(String account);
	
	public Result getCommodityByPrice(String beginPrice,String endPrice,String beginSize, String endSize,String water,String color,String categoryId,String second_category,int page,String account);
	
	public Result totalCommodity();
	
	public Result getCommodityByNew(String account,String agentId);
	
	public Result getCommodityByHot(String account,String agentId);
	
	public Result selectComAndSup(JSONObject data);
	
	public Result selectByPage(String categoryId,int page,String second_category);
	
	public Result selectByPageHot(String name,String categoryId,int page,String second_category,String account);
	
	public Result selectByPageNew(String name,String categoryId,int page,String second_category,String account);
	
	public Result selectByPagePrice(String name,String categoryId,int page,String second_category,HttpSession session,String type);
	
	public Result selectByPageLike(String name,int page,String account);
}
