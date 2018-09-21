package com.jade.manage.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jade.manage.service.NoticeService;
import com.jade.po.Result;

@Controller
@RequestMapping("/notice")
public class NoticeAction {

	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 获取公共列表
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/getNoticeList.action",method=RequestMethod.POST)
	public @ResponseBody Result getNoticeList(HttpSession session){
		String agentId = (String) session.getAttribute("agentId");
		return noticeService.getNoticeList(agentId);
		
	}
	
	/**
	 * 浏览公告
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/browse.action",method=RequestMethod.POST)
	public @ResponseBody Result browse(@RequestBody JSONObject data){
		return noticeService.browse(data);
		
	}
	/**
	 * 上线/下线
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/isONLine.action",method=RequestMethod.POST)
	public @ResponseBody Result isONLine(@RequestBody JSONObject data,HttpSession session){
		String agentId = (String)session.getAttribute("agentId");
		return noticeService.isONLine(data,agentId);
		
	}
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/delNotice.action",method=RequestMethod.POST)
	public @ResponseBody Result delNotice(@RequestBody JSONObject data){
		return noticeService.delNotice(data);
		
	}
	/**
	 * 新增公告
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/addNotice.action",method=RequestMethod.POST)
	public @ResponseBody Result addNotice(@RequestBody JSONObject data,HttpSession session){
		String agentId = (String)session.getAttribute("agentId");
		return noticeService.addNotice(data,agentId);
		
	}
}
