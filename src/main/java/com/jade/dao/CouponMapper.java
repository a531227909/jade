package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.Coupon;
import com.jade.mod.UserCoupon;

public interface CouponMapper {
    
    List<Coupon> selectCoupon(@Param("pageAmount")String pageAmount,@Param("pageSize")String pageSize);
    
    List<UserCoupon> selectUserCouponByAccount(@Param("account")String account);
    
    UserCoupon selectUserCouponByID(@Param("user_coupon_id")String user_coupon_id);
    
    Coupon selectCouponById(@Param("coupon_id")String coupon_id);
    
    int selectAllCouponCount();
    
    int updateCouponCount(@Param("coupon_id")String coupon_id, @Param("count")String count,
    		@Param("count_version")String count_version, @Param("next_count_version")String next_count_version);
    
    int insertUserCouponCount(UserCoupon userCoupon);
    
}