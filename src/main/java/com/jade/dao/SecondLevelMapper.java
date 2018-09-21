package com.jade.dao;

import com.jade.mod.SecondLevel;
import com.jade.mod.SecondLevelExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SecondLevelMapper {
    int countByExample(SecondLevelExample example);

    int deleteByExample(SecondLevelExample example);

    int deleteByPrimaryKey(String id);

    int insert(SecondLevel record);

    int insertSelective(SecondLevel record);

    List<SecondLevel> selectByExample(SecondLevelExample example);

    SecondLevel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SecondLevel record, @Param("example") SecondLevelExample example);

    int updateByExample(@Param("record") SecondLevel record, @Param("example") SecondLevelExample example);

    int updateByPrimaryKeySelective(SecondLevel record);

    int updateByPrimaryKey(SecondLevel record);
    
    List<Map<String,Object>> getByExample(SecondLevelExample example);
}