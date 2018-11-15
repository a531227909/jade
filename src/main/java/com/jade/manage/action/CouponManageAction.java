package com.jade.manage.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.CouponManageService;
import com.jade.mod.Coupon;
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
	
	/**
	 * 新增优惠券
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/insertCoupon.action",method=RequestMethod.POST)
	public @ResponseBody Result insertCoupon(Coupon coupon){
		Result result = new Result();
		if(StringUtils.isBlank(coupon.getCoupon_name())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券名称不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getUser_type())){
			//默认设置用户类型为1;
			coupon.setUser_type("1");
//			result.setSuccess(false);
//			result.getResult().put("msg", "用户类型不能为空");
//			return result;
		}else if(StringUtils.isBlank(coupon.getDate_of_start())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券开始时间不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getDate_of_arrival())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券结束时间不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getCoupon_type())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券类型不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getCoupon_rule())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券规则不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getIs_use_time())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券是否开启限制时间不能为空");
			return result;
		}else if(coupon.getIs_use_time().equals("0")){
			if(StringUtils.isBlank(coupon.getTerm_of_validity())){
				result.setSuccess(false);
				result.getResult().put("msg", "添加失败:优惠券有效期不能为空");
				return result;
			}
		}else if(StringUtils.isBlank(coupon.getCount())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券数量不能为空");
			return result;
		}else if(StringUtils.isBlank(coupon.getStatus())){
			result.setSuccess(false);
			result.getResult().put("msg", "添加失败:优惠券是否启用不能为空");
			return result;
		}
		result = couponManageService.insertCoupon(coupon);
		return result;
	}
	
	/**
	 * 更新优惠券状态 0:启用 1:停用
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/updateCouponStatus.action",method=RequestMethod.POST)
	public @ResponseBody Result updateCouponStatus(String status, String coupon_id){
		return couponManageService.updateCouponStatus(status, coupon_id);
	}
	
	/**
	 * 删除优惠券
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/deleteCoupon.action",method=RequestMethod.POST)
	public @ResponseBody Result deleteCoupon(String coupon_id){
		return couponManageService.deleteCoupon(coupon_id);
	}
	
}
