package com.jade.mod;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    private String id;

    private String cid;

    private String uName;

    private String uImg;

    private String uEvaluate;

    private Date evaluateTime;

    private String cName;

    private String cNumber;

    private String cImg;

    private String account;

    private String reserve;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg == null ? null : uImg.trim();
    }

    public String getuEvaluate() {
        return uEvaluate;
    }

    public void setuEvaluate(String uEvaluate) {
        this.uEvaluate = uEvaluate == null ? null : uEvaluate.trim();
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber == null ? null : cNumber.trim();
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg == null ? null : cImg.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", uName=").append(uName);
        sb.append(", uImg=").append(uImg);
        sb.append(", uEvaluate=").append(uEvaluate);
        sb.append(", evaluateTime=").append(evaluateTime);
        sb.append(", cName=").append(cName);
        sb.append(", cNumber=").append(cNumber);
        sb.append(", cImg=").append(cImg);
        sb.append(", account=").append(account);
        sb.append(", reserve=").append(reserve);
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
        Evaluate other = (Evaluate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuImg() == null ? other.getuImg() == null : this.getuImg().equals(other.getuImg()))
            && (this.getuEvaluate() == null ? other.getuEvaluate() == null : this.getuEvaluate().equals(other.getuEvaluate()))
            && (this.getEvaluateTime() == null ? other.getEvaluateTime() == null : this.getEvaluateTime().equals(other.getEvaluateTime()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getcNumber() == null ? other.getcNumber() == null : this.getcNumber().equals(other.getcNumber()))
            && (this.getcImg() == null ? other.getcImg() == null : this.getcImg().equals(other.getcImg()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuImg() == null) ? 0 : getuImg().hashCode());
        result = prime * result + ((getuEvaluate() == null) ? 0 : getuEvaluate().hashCode());
        result = prime * result + ((getEvaluateTime() == null) ? 0 : getEvaluateTime().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getcNumber() == null) ? 0 : getcNumber().hashCode());
        result = prime * result + ((getcImg() == null) ? 0 : getcImg().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        return result;
    }
}