package com.jade.dao;

import com.jade.mod.FirstAuthority;
import com.jade.mod.FirstAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstAuthorityMapper {
    int countByExample(FirstAuthorityExample example);

    int deleteByExample(FirstAuthorityExample example);

    int deleteByPrimaryKey(String firstAuthorityId);

    int insert(FirstAuthority record);

    int insertSelective(FirstAuthority record);

    List<FirstAuthority> selectByExample(FirstAuthorityExample example);

    FirstAuthority selectByPrimaryKey(String firstAuthorityId);

    int updateByExampleSelective(@Param("record") FirstAuthority record, @Param("example") FirstAuthorityExample example);

    int updateByExample(@Param("record") FirstAuthority record, @Param("example") FirstAuthorityExample example);

    int updateByPrimaryKeySelective(FirstAuthority record);

    int updateByPrimaryKey(FirstAuthority record);
}