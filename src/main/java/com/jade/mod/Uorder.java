package com.jade.mod;

import java.io.Serializable;
import java.util.Date;

public class Uorder implements Serializable {
    private String orderId;

    private String cid;

    private String type;

    private String sid;

    private String rid;

    private Date orderTime;

    private Date recevingTime;

    private Date endTime;

    private String account;

    private String reserve;
    //数量
    private String number;
    //支付金额
    private String money;
    //用户优惠券ID
    private String user_coupon_id;
    //用户优惠金额
    private String user_coupon_money;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getRecevingTime() {
        return recevingTime;
    }

    public void setRecevingTime(Date recevingTime) {
        this.recevingTime = recevingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
    
    public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getUser_coupon_id() {
		return user_coupon_id;
	}

	public void setUser_coupon_id(String user_coupon_id) {
		this.user_coupon_id = user_coupon_id;
	}

	public String getUser_coupon_money() {
		return user_coupon_money;
	}

	public void setUser_coupon_money(String user_coupon_money) {
		this.user_coupon_money = user_coupon_money;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", cid=").append(cid);
        sb.append(", type=").append(type);
        sb.append(", sid=").append(sid);
        sb.append(", rid=").append(rid);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", recevingTime=").append(recevingTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", account=").append(account);
        sb.append(", reserve=").append(reserve);
        sb.append(", number=").append(number);
        sb.append(", money=").append(money);
        sb.append(", user_coupon_id=").append(user_coupon_id);
        sb.append(", user_coupon_money=").append(user_coupon_money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Uorder other = (Uorder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getRecevingTime() == null ? other.getRecevingTime() == null : this.getRecevingTime().equals(other.getRecevingTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getUser_coupon_id() == null ? other.getUser_coupon_id() == null : this.getUser_coupon_id().equals(other.getUser_coupon_id()))
            && (this.getUser_coupon_money() == null ? other.getUser_coupon_money() == null : this.getUser_coupon_money().equals(other.getUser_coupon_money()));
        
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getRecevingTime() == null) ? 0 : getRecevingTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getUser_coupon_id() == null) ? 0 : getUser_coupon_id().hashCode());
        result = prime * result + ((getUser_coupon_money() == null) ? 0 : getUser_coupon_money().hashCode());
        return result;
    }
}