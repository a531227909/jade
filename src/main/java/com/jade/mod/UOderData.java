package com.jade.mod;

import java.io.Serializable;

public class UOderData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 用户订单数据ID
	 */
	private String u_order_data_id;
	/*
	 * 用户订单数据
	 */
	private String data;
	/*
	 * 是否成功回调 0:是 1:否
	 */
	private String is_callback;
	/*
	 * 创建时间
	 */
	private String create_time;
	
	public String getU_order_data_id() {
		return u_order_data_id;
	}
	public void setU_order_data_id(String u_order_data_id) {
		this.u_order_data_id = u_order_data_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getIs_callback() {
		return is_callback;
	}
	public void setIs_callback(String is_callback) {
		this.is_callback = is_callback;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	@Override
	public String toString() {
		return "UOderData [u_order_data_id=" + u_order_data_id + ", data=" + data + ", is_callback=" + is_callback
				+ ", create_time=" + create_time + "]";
	}
	
}