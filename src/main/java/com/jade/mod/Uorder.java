package com.jade.mod;

import java.io.Serializable;
import java.util.Date;

public class Uorder implements Serializable {
	
	private String id;
	
	private String orderId;
	
	private String order_id;

    private String cid;

    private String type;

    private String sid;

    private String rid;
    
    private String color;
    
    private String size;

    private Date orderTime;
    
    private Date order_time;

    private Date recevingTime;
    
    private Date receving_time;

    private Date endTime;
    
    private Date end_time;

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
    
    public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Date getReceving_time() {
		return receving_time;
	}

	public void setReceving_time(Date receving_time) {
		this.receving_time = receving_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
    
    public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
		return "Uorder [id=" + id + ", orderId=" + orderId + ", order_id=" + order_id + ", cid=" + cid + ", type="
				+ type + ", sid=" + sid + ", rid=" + rid + ", color=" + color + ", size=" + size + ", orderTime="
				+ orderTime + ", order_time=" + order_time + ", recevingTime=" + recevingTime + ", receving_time="
				+ receving_time + ", endTime=" + endTime + ", end_time=" + end_time + ", account=" + account
				+ ", reserve=" + reserve + ", number=" + number + ", money=" + money + ", user_coupon_id="
				+ user_coupon_id + ", user_coupon_money=" + user_coupon_money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_time == null) ? 0 : order_time.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((recevingTime == null) ? 0 : recevingTime.hashCode());
		result = prime * result + ((receving_time == null) ? 0 : receving_time.hashCode());
		result = prime * result + ((reserve == null) ? 0 : reserve.hashCode());
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user_coupon_id == null) ? 0 : user_coupon_id.hashCode());
		result = prime * result + ((user_coupon_money == null) ? 0 : user_coupon_money.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uorder other = (Uorder) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (order_time == null) {
			if (other.order_time != null)
				return false;
		} else if (!order_time.equals(other.order_time))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (recevingTime == null) {
			if (other.recevingTime != null)
				return false;
		} else if (!recevingTime.equals(other.recevingTime))
			return false;
		if (receving_time == null) {
			if (other.receving_time != null)
				return false;
		} else if (!receving_time.equals(other.receving_time))
			return false;
		if (reserve == null) {
			if (other.reserve != null)
				return false;
		} else if (!reserve.equals(other.reserve))
			return false;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_coupon_id == null) {
			if (other.user_coupon_id != null)
				return false;
		} else if (!user_coupon_id.equals(other.user_coupon_id))
			return false;
		if (user_coupon_money == null) {
			if (other.user_coupon_money != null)
				return false;
		} else if (!user_coupon_money.equals(other.user_coupon_money))
			return false;
		return true;
	}

}