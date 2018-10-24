package com.jade.mod;

import java.io.Serializable;

public class UserCoupon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 自增ID
	 */
	private String ucp_id;
	/*
	 * 用户优惠券ID
	 */
	private String user_coupon_id;
	/*
	 * 优惠券ID
	 */
	private String coupon_id;
	/*
	 * 用户ID
	 */
	private String account;
	/*
	 * 优惠券名称
	 */
	private String coupon_name;
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
	 * 领取时间
	 */
	private String create_time;
	/*
	 * 商品ID(使用后才有)
	 */
	private String cid;
	/*
	 * 状态 使用还是未使用 0:已使用 1:未使用
	 */
	private String status;
	
	public String getUcp_id() {
		return ucp_id;
	}
	public void setUcp_id(String ucp_id) {
		this.ucp_id = ucp_id;
	}
	public String getUser_coupon_id() {
		return user_coupon_id;
	}
	public void setUser_coupon_id(String user_coupon_id) {
		this.user_coupon_id = user_coupon_id;
	}
	public String getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
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
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UserCoupon [ucp_id=" + ucp_id + ", user_coupon_id=" + user_coupon_id + ", account=" + account
				+ ", coupon_id=" + coupon_id + ", coupon_name=" + coupon_name + ", coupon_type=" + coupon_type
				+ ", coupon_rule=" + coupon_rule + ", term_of_validity=" + term_of_validity + ", create_time="
				+ create_time + ", cid=" + cid + ", status=" + status + "]";
	}
	
}