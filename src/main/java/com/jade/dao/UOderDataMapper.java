package com.jade.dao;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.UOderData;

public interface UOderDataMapper {
    
    UOderData selectUOderDataByID(@Param("u_order_data_id")String u_order_data_id);
    
    int updateIsCallBackByID(@Param("is_callback")String is_callback,@Param("u_order_data_id")String u_order_data_id);
    
    int deleteUOderDataByID(@Param("u_order_data_id")String u_order_data_id);
    
    int insertUOderData(UOderData uOderData);
    
}