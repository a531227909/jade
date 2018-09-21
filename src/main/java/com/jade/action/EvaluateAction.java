package com.jade.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.EvaluateService;
import com.jade.service.IdeaService;

@Controller
@RequestMapping(value="evaluate")
public class EvaluateAction {

	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private IdeaService ideaService;
	/**
	 * 查询所有评论
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/selectEvaluate.action",method=RequestMethod.POST)
	public @ResponseBody Result selectEvaluate(String cid,int page){
		if(page<1){
			page=1;
		}
		return evaluateService.selectEvaluate(cid,page);
		
	}
	/**
	 * 写评论
	 * @param account
	 * @param cid
	 * @param uEvaluate
	 * @return
	 */
	@RequestMapping(value="/writeEvaluate.action",method=RequestMethod.POST)
	public @ResponseBody Result writeEvaluate(HttpSession session, String cid,String uEvaluate,String orderId){
		String account = (String) session.getAttribute("account");
		return evaluateService.writeEvaluate(account, cid, uEvaluate,orderId);
		
	}
	/**
	 * 写意见
	 * @param account
	 * @param cid
	 * @param uEvaluate
	 * @return
	 */
	@RequestMapping(value="/insertIdea.action",method=RequestMethod.POST)
	public @ResponseBody Result insertIdea(HttpSession session,  String content){
		String account = (String) session.getAttribute("account");
		return ideaService.insertIdea(account,content);
		
	}

}
