package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.Coupon;

public interface CouponMapper {
    
    List<Coupon> selectCoupon(@Param("pageAmount")String pageAmount,@Param("pageSize")String pageSize);
    
    int selectAllCouponCount();
    
}