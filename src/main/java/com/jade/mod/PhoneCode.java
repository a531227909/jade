package com.jade.mod;

import java.io.Serializable;

public class PhoneCode implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 手机号码
	 */
	private String phone_num;
	/*
	 * 验证码
	 */
	private String code;
	/*
	 * 更新时间
	 */
	private String update_time;
	
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public String toString() {
		return "PhoneCode [phone_num=" + phone_num + ", code=" + code + ", update_time=" + update_time + "]";
	}
	
}