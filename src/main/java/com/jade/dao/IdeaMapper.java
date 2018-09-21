package com.jade.dao;

import com.jade.mod.Idea;
import com.jade.mod.IdeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdeaMapper {
    int countByExample(IdeaExample example);

    int deleteByExample(IdeaExample example);

    int deleteByPrimaryKey(String ideaId);

    int insert(Idea record);

    int insertSelective(Idea record);

    List<Idea> selectByExampleWithBLOBs(IdeaExample example);

    List<Idea> selectByExample(IdeaExample example);

    Idea selectByPrimaryKey(String ideaId);

    int updateByExampleSelective(@Param("record") Idea record, @Param("example") IdeaExample example);

    int updateByExampleWithBLOBs(@Param("record") Idea record, @Param("example") IdeaExample example);

    int updateByExample(@Param("record") Idea record, @Param("example") IdeaExample example);

    int updateByPrimaryKeySelective(Idea record);

    int updateByPrimaryKeyWithBLOBs(Idea record);

    int updateByPrimaryKey(Idea record);
}