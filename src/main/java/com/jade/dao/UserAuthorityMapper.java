package com.jade.dao;

import com.jade.mod.UserAuthority;
import com.jade.mod.UserAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthorityMapper {
    int countByExample(UserAuthorityExample example);

    int deleteByExample(UserAuthorityExample example);

    int deleteByPrimaryKey(String userAuthorityId);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    List<UserAuthority> selectByExample(UserAuthorityExample example);

    UserAuthority selectByPrimaryKey(String userAuthorityId);

    int updateByExampleSelective(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);

    int updateByExample(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);
    
    List<String> selectAuthorityId(String account);
}