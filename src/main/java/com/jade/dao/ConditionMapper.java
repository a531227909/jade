package com.jade.dao;

import com.jade.mod.Condition;
import com.jade.mod.ConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConditionMapper {
    int countByExample(ConditionExample example);

    int deleteByExample(ConditionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Condition record);

    int insertSelective(Condition record);

    List<Condition> selectByExample(ConditionExample example);

    Condition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Condition record, @Param("example") ConditionExample example);

    int updateByExample(@Param("record") Condition record, @Param("example") ConditionExample example);

    int updateByPrimaryKeySelective(Condition record);

    int updateByPrimaryKey(Condition record);
}