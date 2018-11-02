package com.jade.manage.service;

import com.jade.mod.Coupon;
import com.jade.po.Result;

public interface CouponManageService {

	public Result selectCoupon(String page);
	
	public Result insertCoupon(Coupon coupon);
	
	public Result updateCouponStatus(String status, String coupon_id);
	
	public Result deleteCoupon(String coupon_id);
	
}
