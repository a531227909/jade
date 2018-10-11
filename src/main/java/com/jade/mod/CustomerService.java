package com.jade.mod;

import java.io.Serializable;

public class CustomerService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public String toString() {
		return "CustomerService [account=" + account + ", customer_service=" + customer_service + ", content=" + content
				+ ", create_time=" + create_time + ", is_read=" + is_read + "]";
	}
	
}