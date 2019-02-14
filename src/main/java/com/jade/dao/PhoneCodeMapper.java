package com.jade.dao;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.PhoneCode;
import com.jade.mod.UserCoupon;

public interface PhoneCodeMapper {
    
    PhoneCode selectPhoneCodeByPhoneNum(@Param("phone_num")String phone_num);
    
    int updateCode(@Param("phone_num")String phone_num, @Param("code")String code);
    
    int insertPhoneCode(@Param("phone_num")String phone_num, @Param("code")String code);
    
}