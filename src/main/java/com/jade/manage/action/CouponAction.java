package com.jade.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.CouponService;

@Controller
@RequestMapping("/coupon")
public class CouponAction {

	@Autowired
	private CouponService couponService;
	
	/**
	 * 获取优惠券列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getCoupon.action",method=RequestMethod.POST)
	public @ResponseBody Result getCouponList(String page){
		return couponService.selectCoupon(page);
	}
	
}
