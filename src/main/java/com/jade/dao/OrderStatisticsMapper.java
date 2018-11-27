package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.Coupon;
import com.jade.mod.Uorder;
import com.jade.mod.UserCoupon;

public interface OrderStatisticsMapper {
    
    List<Uorder> selectOrderStatisticsByDate(@Param("account")String account, @Param("startTime")String startTime, @Param("endTime")String endTime,
    		@Param("pageAmount")String pageAmount, @Param("pageSize")String pageSize);
    
    int selectOrderCount(@Param("account")String account, @Param("startTime")String startTime, @Param("endTime")String endTime);
    
}