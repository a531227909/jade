package com.jade.mod;

import java.io.Serializable;

public class SecondAuthority implements Serializable {
    private String secondAuthorityId;

    private String secondAuthorityName;

    private String belongto;

    private static final long serialVersionUID = 1L;

    public String getSecondAuthorityId() {
        return secondAuthorityId;
    }

    public void setSecondAuthorityId(String secondAuthorityId) {
        this.secondAuthorityId = secondAuthorityId == null ? null : secondAuthorityId.trim();
    }

    public String getSecondAuthorityName() {
        return secondAuthorityName;
    }

    public void setSecondAuthorityName(String secondAuthorityName) {
        this.secondAuthorityName = secondAuthorityName == null ? null : secondAuthorityName.trim();
    }

    public String getBelongto() {
        return belongto;
    }

    public void setBelongto(String belongto) {
        this.belongto = belongto == null ? null : belongto.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", secondAuthorityId=").append(secondAuthorityId);
        sb.append(", secondAuthorityName=").append(secondAuthorityName);
        sb.append(", belongto=").append(belongto);
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
        SecondAuthority other = (SecondAuthority) that;
        return (this.getSecondAuthorityId() == null ? other.getSecondAuthorityId() == null : this.getSecondAuthorityId().equals(other.getSecondAuthorityId()))
            && (this.getSecondAuthorityName() == null ? other.getSecondAuthorityName() == null : this.getSecondAuthorityName().equals(other.getSecondAuthorityName()))
            && (this.getBelongto() == null ? other.getBelongto() == null : this.getBelongto().equals(other.getBelongto()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSecondAuthorityId() == null) ? 0 : getSecondAuthorityId().hashCode());
        result = prime * result + ((getSecondAuthorityName() == null) ? 0 : getSecondAuthorityName().hashCode());
        result = prime * result + ((getBelongto() == null) ? 0 : getBelongto().hashCode());
        return result;
    }
}