package com.jade.dao;

import com.jade.mod.ThirdlyAuthority;
import com.jade.mod.ThirdlyAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdlyAuthorityMapper {
    int countByExample(ThirdlyAuthorityExample example);

    int deleteByExample(ThirdlyAuthorityExample example);

    int deleteByPrimaryKey(String thirdlyAuthorityId);

    int insert(ThirdlyAuthority record);

    int insertSelective(ThirdlyAuthority record);

    List<ThirdlyAuthority> selectByExample(ThirdlyAuthorityExample example);

    ThirdlyAuthority selectByPrimaryKey(String thirdlyAuthorityId);

    int updateByExampleSelective(@Param("record") ThirdlyAuthority record, @Param("example") ThirdlyAuthorityExample example);

    int updateByExample(@Param("record") ThirdlyAuthority record, @Param("example") ThirdlyAuthorityExample example);

    int updateByPrimaryKeySelective(ThirdlyAuthority record);

    int updateByPrimaryKey(ThirdlyAuthority record);
}