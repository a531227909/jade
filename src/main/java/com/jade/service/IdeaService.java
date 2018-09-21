package com.jade.service;

import com.jade.po.Result;

public interface IdeaService {

	//添加意见
	public Result insertIdea(String account,String content);
	//获取意见
	public Result selectIdea();

}
