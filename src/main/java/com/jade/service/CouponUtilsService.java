package com.jade.service;

import com.jade.po.Result;

public interface CouponUtilsService {

	public Result updateCouponCount(String coupon_id, String count, String count_version, String next_count_version);
	
}
