package com.jade.dao;

import com.jade.mod.Uorder;
import com.jade.mod.UorderExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UorderMapper {
    int countByExample(UorderExample example);

    int deleteByExample(UorderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Uorder record);

    int insertSelective(Uorder record);

    List<Uorder> selectByExample(UorderExample example);

    Uorder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Uorder record, @Param("example") UorderExample example);

    int updateByExample(@Param("record") Uorder record, @Param("example") UorderExample example);

    int updateByPrimaryKeySelective(Uorder record);

    int updateByPrimaryKey(Uorder record);
    
    int updateByTime();
    
    List<Map<String,Object>> selectByTime();
    
    List<Map<String,Object>> selectByOrderId(String orderId);
    
    int selectByType3(String orderId);
    
    int selectByType2(String orderId);
    
    int selectByType1(String orderId);
    
    int updateByTimeToClose();
    
    List<Map<String,Object>> getMyAllUOrder(Map map);
    
    List<Map<String,Object>> selectByOrderIdtoOne(String orderId);
    
    int countMyAllUOrder(Map map);
    Map<String,Object> getComAndRecInType1(String orderId);
    
    void insertByTime();
}