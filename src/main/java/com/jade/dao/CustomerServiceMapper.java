package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.CustomerService;

public interface CustomerServiceMapper {

    int insert(CustomerService customerService);

    List<CustomerService> selectByAccount(@Param("account")String account);
    
    int updateIsRead(@Param("is_read")String is_read, @Param("account")String account);
}