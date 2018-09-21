package com.jade.dao;

import com.jade.mod.UserBug;
import com.jade.mod.UserBugExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserBugMapper {
    int countByExample(UserBugExample example);

    int deleteByExample(UserBugExample example);

    int deleteByPrimaryKey(String account);

    int insert(UserBug record);

    int insertSelective(UserBug record);

    List<UserBug> selectByExample(UserBugExample example);

    UserBug selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") UserBug record, @Param("example") UserBugExample example);

    int updateByExample(@Param("record") UserBug record, @Param("example") UserBugExample example);

    int updateByPrimaryKeySelective(UserBug record);

    int updateByPrimaryKey(UserBug record);
    

    List<Map<String,Object>> selectUserList(Map map);
}