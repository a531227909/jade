package com.jade.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.CouponManageService;
import com.jade.po.Result;

@Controller
@RequestMapping("/couponManage")
public class CouponManageAction {

	@Autowired
	private CouponManageService couponManageService;
	
	/**
	 * 获取优惠券列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getCouponList.action",method=RequestMethod.POST)
	public @ResponseBody Result getCouponList(String page){
		return couponManageService.selectCoupon(page);
	}
	
}
