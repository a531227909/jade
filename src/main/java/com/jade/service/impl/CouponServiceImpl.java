package com.jade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CouponMapper;
import com.jade.mod.Coupon;
import com.jade.mod.UserCoupon;
import com.jade.po.Result;
import com.jade.service.CouponService;
import com.jade.service.CouponUtilsService;
import com.jade.uitil.GetCouponOrderNumberUtils;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponMapper couponMapper;
	
	@Autowired
	private CouponUtilsService couponUtilsService;
	/*
	 * 分页数据量（每页多少数据）
	 */
	final static String pageSize = "10";

	@Override
	public Result selectCoupon(String page) {
		Result result = new Result();
		String pageAmount = String.valueOf((Integer.parseInt(page)-1)*Integer.parseInt(pageSize));
		List<Coupon> coupons = couponMapper.selectCoupon(pageAmount, pageSize);
		int allCount = couponMapper.selectAllCouponCount();
		result.setSuccess(true);
		result.getResult().put("data", coupons);
		result.getResult().put("pages", String.valueOf(allCount/Integer.parseInt(pageSize)+1));
		return result;
	}

	@Override
	public Result getOneCoupon(String account, String coupon_id) {
		Result result = new Result();
		Coupon coupon = couponMapper.selectCouponById(coupon_id);
		if(coupon==null||coupon.equals("")){
			result.setSuccess(false);
			result.getResult().put("msg", "优惠券不存在");
			return result;
		}else{
			if(coupon.getCount().equals("0")){
				result.setSuccess(false);
				result.getResult().put("msg", "库存为0");
				return result;
			}else{
				String count = String.valueOf(Integer.parseInt(coupon.getCount())-1);
				int count_version = coupon.getCount_version();
				int next_count_version = count_version+1;
				//此处使用迭代方便保证库存同步
				Result updateResult = couponUtilsService.updateCouponCount(coupon_id, count, String.valueOf(count_version), String.valueOf(next_count_version));
				if(updateResult.isSuccess()){
					UserCoupon userCoupon = new UserCoupon();
					userCoupon.setUser_coupon_id(GetCouponOrderNumberUtils.GetCouponOrderNumber());
					userCoupon.setCoupon_id(coupon.getCoupon_id());
					userCoupon.setAccount(account);
					userCoupon.setCoupon_name(coupon.getCoupon_name());
					userCoupon.setCoupon_type(coupon.getCoupon_type());
					userCoupon.setCoupon_rule(coupon.getCoupon_rule());
					userCoupon.setTerm_of_validity(coupon.getTerm_of_validity());
					couponMapper.insertUserCouponCount(userCoupon);
					result.setSuccess(true);
					result.getResult().put("msg", "领取成功");
					return result;
				}else{
					return updateResult;
				}
			}
		}
	}
	
}
