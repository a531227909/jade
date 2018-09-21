package com.jade.dao;

import com.jade.mod.SecondAuthority;
import com.jade.mod.SecondAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondAuthorityMapper {
    int countByExample(SecondAuthorityExample example);

    int deleteByExample(SecondAuthorityExample example);

    int deleteByPrimaryKey(String secondAuthorityId);

    int insert(SecondAuthority record);

    int insertSelective(SecondAuthority record);

    List<SecondAuthority> selectByExample(SecondAuthorityExample example);

    SecondAuthority selectByPrimaryKey(String secondAuthorityId);

    int updateByExampleSelective(@Param("record") SecondAuthority record, @Param("example") SecondAuthorityExample example);

    int updateByExample(@Param("record") SecondAuthority record, @Param("example") SecondAuthorityExample example);

    int updateByPrimaryKeySelective(SecondAuthority record);

    int updateByPrimaryKey(SecondAuthority record);
}