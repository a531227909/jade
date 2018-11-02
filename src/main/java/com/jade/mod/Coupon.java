package com.jade.mod;

import java.io.Serializable;

public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 自增ID
	 */
	private String cp_id;
	/*
	 * 优惠券ID
	 */
	private String coupon_id;
	/*
	 * 优惠券名称
	 */
	private String coupon_name;
	/*
	 * 用户类型
	 */
	private String user_type;
	/*
	 * 开始日期 yyyyMMddHHmmss
	 */
	private String date_of_start;
	/*
	 * 终止日期 yyyyMMddHHmmss
	 */
	private String date_of_arrival;
	/*
	 * 优惠券种类  暂时只有 1：通用优惠券（全场通用）
	 */
	private String coupon_type;
	/*
	 * 优惠券规则 根据coupon_type自定义规则，如1：满多少减多少 100-20
	 */
	private String coupon_rule;
	/*
	 * 有效期
	 */
	private String term_of_validity;
	/*
	 * 是否开启有效期 0:开启 1:关闭
	 */
	private String is_use_time;
	/*
	 * 数量
	 */
	private String count;
	/*
	 * 数量版本(控制库存)
	 */
	private int count_version;
	/*
	 * 备注
	 */
	private String memo;
	/*
	 * 状态 启用还是停用 0:启用 1:停用
	 */
	private String status;
	/*
	 * 创建时间
	 */
	private String create_time;
	
	public String getCp_id() {
		return cp_id;
	}
	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getDate_of_start() {
		return date_of_start;
	}
	public void setDate_of_start(String date_of_start) {
		this.date_of_start = date_of_start;
	}
	public String getDate_of_arrival() {
		return date_of_arrival;
	}
	public void setDate_of_arrival(String date_of_arrival) {
		this.date_of_arrival = date_of_arrival;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}
	public String getCoupon_rule() {
		return coupon_rule;
	}
	public void setCoupon_rule(String coupon_rule) {
		this.coupon_rule = coupon_rule;
	}
	public String getTerm_of_validity() {
		return term_of_validity;
	}
	public void setTerm_of_validity(String term_of_validity) {
		this.term_of_validity = term_of_validity;
	}
	public String getIs_use_time() {
		return is_use_time;
	}
	public void setIs_use_time(String is_use_time) {
		this.is_use_time = is_use_time;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getCount_version() {
		return count_version;
	}
	public void setCount_version(int count_version) {
		this.count_version = count_version;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	@Override
	public String toString() {
		return "Coupon [cp_id=" + cp_id + ", coupon_id=" + coupon_id + ", coupon_name=" + coupon_name + ", user_type="
				+ user_type + ", date_of_start=" + date_of_start + ", date_of_arrival=" + date_of_arrival
				+ ", coupon_type=" + coupon_type + ", coupon_rule=" + coupon_rule + ", term_of_validity="
				+ term_of_validity + ", is_use_time=" + is_use_time + ", count=" + count + ", count_version="
				+ count_version + ", memo=" + memo + ", status=" + status + ", create_time=" + create_time + "]";
	}
	
}