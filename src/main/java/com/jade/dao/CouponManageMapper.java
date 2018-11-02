package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.Coupon;

public interface CouponManageMapper {
    
    List<Coupon> selectCoupon(@Param("pageAmount")String pageAmount,@Param("pageSize")String pageSize);
    
    int selectAllCouponCount();
    
    int insertCoupon(Coupon coupon);
    
    int updateCouponStatus(@Param("status")String status, @Param("coupon_id")String coupon_id);
    
    int deleteCoupon(@Param("coupon_id")String coupon_id);
    
}