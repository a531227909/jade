package com.jade.service;

import com.jade.po.Result;

public interface CouponService {

	public Result selectCoupon(String page);
	
	public Result getOneCoupon(String account, String coupon_id);
	
	public Result selectUserCouponByAccount(String account);
	
}
