package com.jade.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.UOrderService;
import com.jade.service.UserPayService;

@Controller
@RequestMapping(value="uorder")
public class UOrderAction {

	@Autowired
	private UOrderService uOrderService;
	@Autowired
	private UserPayService userPayService;
	
	/**
	 * 插入下单信息
	 * @return
	 */
	@RequestMapping(value="/insertOrder.action",method=RequestMethod.POST)
	public @ResponseBody Result insertOrder(@RequestBody JSONObject data, HttpSession session){
		String account = (String) session.getAttribute("account");
			return uOrderService.insertOrder(data, account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 购物车插入下单信息
	 * @return
	 */
	@RequestMapping(value="/insertOrderByCart.action",method=RequestMethod.POST)
	public @ResponseBody Result insertOrderByCart(@RequestBody JSONObject data, HttpSession session){
		String account = (String) session.getAttribute("account");
		data.put("account", account);
		System.out.println(data.toString());
		return userPayService.pay(data, account);
//			return uOrderService.insertOrderByCart(data, account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 根据类型查询下单信息
	 * @return
	 */
	@RequestMapping(value="/selectOrderByType.action",method=RequestMethod.POST)
	public @ResponseBody Result selectOrderByType(String type, HttpSession session,int page){
		String account = (String) session.getAttribute("account");
			return uOrderService.selectOrderByType(type, account,page);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}

	

	/**
	 * 根据下单号删除下单信息
	 * @return
	 */
	@RequestMapping(value="/delOrder.action",method=RequestMethod.POST)
	public @ResponseBody Result delOrder(String orderId, HttpSession session){
		String account = (String) session.getAttribute("account");
			return uOrderService.delOrder(orderId, account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	
	/**
	 * 根据下单号查询下单信息
	 * @return
	 */
	@RequestMapping(value="/selectByOrderId.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByOrderId(String orderId){
	
			return uOrderService.selectByOrderId(orderId);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 修改待收货为收货状态
	 * @return
	 */
	@RequestMapping(value="/updateOrder.action",method=RequestMethod.POST)
	public @ResponseBody Result updateOrder(String orderId, String type,HttpSession session){
			String account = (String)session.getAttribute("account");
			return uOrderService.updateOrder(orderId,type,account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}

}
