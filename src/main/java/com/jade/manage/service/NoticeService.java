package com.jade.manage.service;

import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface NoticeService {

	/**
	 * 获取公共列表
	 * @return
	 */
	public Result getNoticeList(String agentId);
	/**
	 * 浏览公告	
	 * @return
	 */
	public Result browse(JSONObject data);
	
	/**
	 * 上线/下线	
	 * @return
	 */
	public Result isONLine(JSONObject data,String agentId);
	
	/**
	 * 删除
	 * @return
	 */
	public Result delNotice(JSONObject data);
	
	
	/**
	 * 新增公告
	 * @return
	 */
	public Result addNotice(JSONObject data,String agentId);
	/**
	 * 根据类型获取公告
	 * @return
	 */
	public Result getNoticByType(String agentId);
	

}
