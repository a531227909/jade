package com.jade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jade.mod.CustomerInformation;
import com.jade.mod.CustomerService;

public interface CustomerServiceMapper {

	int insert(CustomerService customerService);
	
	int insertCustomerInformation(CustomerInformation customerInformation);
	
	CustomerInformation selectCustomerInformation(@Param("account")String account);
    
	List<CustomerService> selectByAccount(@Param("account")String account);
	
	List<CustomerService> selectLastByAccount(@Param("account")String account, @Param("is_read")String is_read, @Param("pageAmount")String pageAmount, @Param("pageSize")String pageSize);
    
    int updateCustomerInformation(@Param("account")String account, @Param("phone")String phone, @Param("name")String name);
    
    int updateIsRead(@Param("is_read")String is_read, @Param("account")String account);
    
    int updateReplyIsRead(@Param("is_read")String is_read, @Param("account")String account);
    
    int selectLastByAccountCount(@Param("account")String account, @Param("is_read")String is_read);
}