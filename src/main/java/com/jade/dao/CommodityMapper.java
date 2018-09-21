package com.jade.dao;

import com.jade.mod.Commodity;
import com.jade.mod.CommodityExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommodityMapper {
    int countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(String cid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);

    Commodity selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
    
    List<Map<String,Object>> selectByPage(CommodityExample example);
    
    List<Map<String,Object>> selectCommodityByCId(String cId);
    
    List<Map<String,Object>> selectCommodityByExample(String account);
    
    int countByDeal();
    
    Map<String,Object> selectComAndSup(String cid);
    
    int countByPage(CommodityExample example);
    
    List<Map<String,Object>> selectByPageHot(CommodityExample example);
    
    List<Map<String,Object>> selectByPageNew(CommodityExample example);
    
    List<Map<String,Object>> selectByPagePrice(CommodityExample example);
    
    List<Map<String,Object>> selectByPageLike(CommodityExample example);
    
    List<Map<String,Object>> selectByPriceE(CommodityExample example);
    
    List<Map<String,Object>> getCommodityList(String sid);
    
    List<Map<String,Object>> getCommoditysoldOut(String sid);
    
    int updateByTimeToClose();
    
}