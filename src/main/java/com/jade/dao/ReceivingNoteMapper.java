package com.jade.dao;

import com.jade.mod.ReceivingNote;
import com.jade.mod.ReceivingNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceivingNoteMapper {
    int countByExample(ReceivingNoteExample example);

    int deleteByExample(ReceivingNoteExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReceivingNote record);

    int insertSelective(ReceivingNote record);

    List<ReceivingNote> selectByExample(ReceivingNoteExample example);

    ReceivingNote selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReceivingNote record, @Param("example") ReceivingNoteExample example);

    int updateByExample(@Param("record") ReceivingNote record, @Param("example") ReceivingNoteExample example);

    int updateByPrimaryKeySelective(ReceivingNote record);

    int updateByPrimaryKey(ReceivingNote record);
}