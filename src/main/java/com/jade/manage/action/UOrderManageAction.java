package com.jade.manage.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.dao.ExpressMapper;
import com.jade.manage.service.ExpressService;
import com.jade.manage.service.UOrderManageService;
import com.jade.po.Result;
import com.jade.service.IdeaService;

@Controller
@RequestMapping("/uorerManage")
public class UOrderManageAction {

	@Autowired
	private UOrderManageService manageService;
	@Autowired
	private ExpressService exService; 
	@Autowired
	private IdeaService ideaService;
	
	/**
	 * 查看某代理商的所有订单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/getMyAllUOrder.action")
	@ResponseBody
	public  Result getMyAllUOrder(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return manageService.getMyAllUOrder(data,account);
		
	}
	/**
	 * 退单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/returnedUOrder.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result returnedUOrder(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return manageService.returnedUOrder(data);
		
	}
	/**
	 * 查看订单（含收货地址，商品详情）
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/checkComAndRec.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result checkComAndRec(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return manageService.checkComAndRec(data);
		
	}
	/**
	 * 改变订单状态（待发货）
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/changeUOrderType.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result changeUOrderType(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return manageService.changeUOrderType(data);
		
	}
	
	/**
	 * 恢复订单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/restoreUOrder.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result restoreUOrder(@RequestBody JSONObject data,HttpSession session){
		String account = (String) session.getAttribute("account");
		return manageService.restoreUOrder(data);
		
	}
	/**
	 * 插入快递信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/insertExpress.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result insertExpress(@RequestBody JSONObject data){
		return exService.insertExpress(data);
		
	}
	/**
	 * 获取意见
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/selectIdea.action",method=RequestMethod.POST)
	@ResponseBody
	public  Result selectIdea(){
		return ideaService.selectIdea();
		
	}

}
