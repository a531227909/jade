package com.jade.dao;

import com.jade.mod.ShoppingCart;
import com.jade.mod.ShoppingCartExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShoppingCartMapper {
    int countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(String id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(String id);
    
    List<ShoppingCart> selectByCidAndAccount(@Param("cid")String cid, @Param("account") String account);
    
    ShoppingCart selectByCidAccount(@Param("cid")String cid, @Param("account") String account);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    
    List<Map<String,Object>> selectBySup(ShoppingCartExample example);
}