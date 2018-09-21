package com.jade.dao;

import com.jade.mod.Performance;
import com.jade.mod.PerformanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerformanceMapper {
    int countByExample(PerformanceExample example);

    int deleteByExample(PerformanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Performance record);

    int insertSelective(Performance record);

    List<Performance> selectByExample(PerformanceExample example);

    Performance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Performance record, @Param("example") PerformanceExample example);

    int updateByExample(@Param("record") Performance record, @Param("example") PerformanceExample example);

    int updateByPrimaryKeySelective(Performance record);

    int updateByPrimaryKey(Performance record);
}