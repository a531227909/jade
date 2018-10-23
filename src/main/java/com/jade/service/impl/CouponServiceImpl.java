package com.jade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CouponMapper;
import com.jade.mod.Coupon;
import com.jade.po.Result;
import com.jade.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponMapper CuouponMapper;
	/*
	 * 分页数据量（每页多少数据）
	 */
	final static String pageSize = "10";

	@Override
	public Result selectCoupon(String page) {
		Result result = new Result();
		String pageAmount = String.valueOf((Integer.parseInt(page)-1)*Integer.parseInt(pageSize));
		List<Coupon> coupons = CuouponMapper.selectCoupon(pageAmount, pageSize);
		int allCount = CuouponMapper.selectAllCouponCount();
		result.setSuccess(true);
		result.getResult().put("data", coupons);
		result.getResult().put("pages", String.valueOf(allCount/Integer.parseInt(pageSize)+1));
		return result;
	}
	
	
}
