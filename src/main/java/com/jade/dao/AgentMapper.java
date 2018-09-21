package com.jade.dao;

import com.jade.mod.Agent;
import com.jade.mod.AgentExample;
import com.jade.mod.CommodityExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AgentMapper {
    int countByExample(AgentExample example);

    int deleteByExample(AgentExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Agent record);

    int insertSelective(Agent record);

    List<Agent> selectByExample(AgentExample example);

    Agent selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Agent record, @Param("example") AgentExample example);

    int updateByExample(@Param("record") Agent record, @Param("example") AgentExample example);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);
    
    List<Map<String,Object>> selectPerformanceByPage(Map map);
    
    int countByPage(Map map);
    
    int countUserByPage(Map map);
    
    List<Map<String,Object>> selectUserByPage(Map map);
    
    List<Map<String,Object>> selectAgentByPage(AgentExample example);
    
    int countAgentByPage(AgentExample example);
    
    int countAgentByPageLike(Map map);
    
    List<Map<String,Object>> selectAgentLikeByPage(Map map);
}