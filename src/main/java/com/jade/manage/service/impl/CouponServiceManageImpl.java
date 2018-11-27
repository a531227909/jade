package com.jade.manage.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CouponManageMapper;
import com.jade.manage.service.CouponManageService;
import com.jade.mod.Coupon;
import com.jade.po.Result;
import com.jade.uitil.GetCouponOrderNumberUtils;

@Service
public class CouponServiceManageImpl implements CouponManageService{

	@Autowired
	private CouponManageMapper couponManageMapper;
	/*
	 * 分页数据量（每页多少数据）
	 */
	final static String pageSize = "10";

	@Override
	public Result selectCoupon(String page) {
		Result result = new Result();
		String pageAmount = String.valueOf((Integer.parseInt(page)-1)*Integer.parseInt(pageSize));
		List<Coupon> coupons = couponManageMapper.selectCoupon(pageAmount, pageSize);
		int allCount = couponManageMapper.selectAllCouponCount();
		float num = (allCount-1)/Integer.parseInt(pageSize)+1;
		result.setSuccess(true);
		result.getResult().put("data", coupons);
		result.getResult().put("totalData", allCount);
		result.getResult().put("pages", Integer.toString((int) Math.floor(num)));
		return result;
	}

	@Override
	public Result insertCoupon(Coupon coupon) {
		Result result = new Result();
		coupon.setCoupon_id(GetCouponOrderNumberUtils.GetCouponOrderNumber());
		int i = couponManageMapper.insertCoupon(coupon);
		if(i==1){
			result.setSuccess(true);
			result.getResult().put("msg", "添加成功");
		}else{
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:系统故障");
		}
		return result;
	}

	@Override
	public Result updateCouponStatus(String status, String coupon_id) {
		Result result = new Result();
		int i = couponManageMapper.updateCouponStatus(status, coupon_id);
		if(i==1){
			result.setSuccess(true);
			result.getResult().put("msg", "更新状态成功");
		}else{
			result.setSuccess(false);
			result.getResult().put("msg", "更新状态失败:系统故障");
		}
		return result;
	}

	@Override
	public Result deleteCoupon(String coupon_id) {
		Result result = new Result();
		int i = couponManageMapper.deleteCoupon(coupon_id);
		if(i==1){
			result.setSuccess(true);
			result.getResult().put("msg", "删除成功");
		}else{
			result.setSuccess(false);
			result.getResult().put("msg", "删除失败:系统故障");
		}
		return result;
	}
	
}
