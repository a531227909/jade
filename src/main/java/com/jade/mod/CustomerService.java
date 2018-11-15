package com.jade.mod;

import java.io.Serializable;

public class CustomerService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private String customer_service_id;
	//用户
	private String account;
	//客服
	private String customer_service;
	//内容
	private String content;
	//创建时间
	private String create_time;
	//0已读，1未读
	private String is_read;
	//电话
	private String phone;
	//姓名
	private String name;
	
	public String getCustomer_service_id() {
		return customer_service_id;
	}
	public void setCustomer_service_id(String customer_service_id) {
		this.customer_service_id = customer_service_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCustomer_service() {
		return customer_service;
	}
	public void setCustomer_service(String customer_service) {
		this.customer_service = customer_service;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getIs_read() {
		return is_read;
	}
	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CustomerService [customer_service_id=" + customer_service_id + ", account=" + account
				+ ", customer_service=" + customer_service + ", content=" + content + ", create_time=" + create_time
				+ ", is_read=" + is_read + ", phone=" + phone + ", name=" + name + "]";
	}
	
}