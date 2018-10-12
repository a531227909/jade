package com.jade.mod;

import java.io.Serializable;

public class CustomerInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//用户
	private String account;
	//电话
	private String phone;
	//姓名
	private String name;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
		return "CustomerInformation [account=" + account + ", phone=" + phone + ", name=" + name + "]";
	}
	
}