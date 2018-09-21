package com.jade.dao;

import com.jade.mod.PurchaseRecords;
import com.jade.mod.PurchaseRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseRecordsMapper {
    int countByExample(PurchaseRecordsExample example);

    int deleteByExample(PurchaseRecordsExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurchaseRecords record);

    int insertSelective(PurchaseRecords record);

    List<PurchaseRecords> selectByExample(PurchaseRecordsExample example);

    PurchaseRecords selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurchaseRecords record, @Param("example") PurchaseRecordsExample example);

    int updateByExample(@Param("record") PurchaseRecords record, @Param("example") PurchaseRecordsExample example);

    int updateByPrimaryKeySelective(PurchaseRecords record);

    int updateByPrimaryKey(PurchaseRecords record);
}