package com.jade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CouponMapper;
import com.jade.mod.Coupon;
import com.jade.po.Result;
import com.jade.service.CouponUtilsService;

@Service
public class CouponUtilsServiceImpl implements CouponUtilsService{

	@Autowired
	private CouponMapper couponMapper;

	@Override
	public Result updateCouponCount(String coupon_id, String count, String count_version, String next_count_version) {
		Coupon coupon = couponMapper.selectCouponById(coupon_id);
		if(coupon.getCount().equals("0")){
			Result result = new Result();
			result.setSuccess(false);
			result.getResult().put("msg", "库存为0");
			return result;
		}else{
			int i = couponMapper.updateCouponCount(coupon_id, count, count_version, next_count_version);
			if(i!=1){
				updateCouponCount(coupon_id, count, count_version, next_count_version);
			}
			Result result = new Result();
			result.setSuccess(true);
			return result;
		}
	}
	
}
