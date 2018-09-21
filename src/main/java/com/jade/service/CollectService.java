package com.jade.service;

import com.jade.po.Result;

public interface CollectService {

	public Result getCollectByUser(String account,int page);
	
	public Result changeCollect(String cId,String account);
}
