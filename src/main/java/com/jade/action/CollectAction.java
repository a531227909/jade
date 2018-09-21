package com.jade.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.CollectService;


@Controller
@RequestMapping(value="collect")
public class CollectAction {

	@Autowired
	private CollectService collectService;
	/**
	 * 鏌ョ湅鐢ㄦ埛鐨勬敹钘�
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/getCollectByUser.action",method=RequestMethod.POST)
	public @ResponseBody Result getCollectByUser(HttpSession session,int page){
		String account = (String) session.getAttribute("account");
		return collectService.getCollectByUser(account,page);
		
	}

	/**
	 * 鐐瑰嚮鏀惰棌鎴栧彇娑堟敹钘忓姛鑳�
	 * @param cId
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/changeCollect.action",method=RequestMethod.POST)
	public @ResponseBody Result changeCollect(HttpServletRequest request,String cid,HttpSession session){
		String account = (String) session.getAttribute("account");
		cid = (String) request.getParameter("cid");
		return collectService.changeCollect(cid, account);
	}
}
