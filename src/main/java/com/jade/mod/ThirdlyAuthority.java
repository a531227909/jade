package com.jade.mod;

import java.io.Serializable;

public class ThirdlyAuthority implements Serializable {
    private String thirdlyAuthorityId;

    private String thirdlyAuthorityName;

    private String belongto;

    private static final long serialVersionUID = 1L;

    public String getThirdlyAuthorityId() {
        return thirdlyAuthorityId;
    }

    public void setThirdlyAuthorityId(String thirdlyAuthorityId) {
        this.thirdlyAuthorityId = thirdlyAuthorityId == null ? null : thirdlyAuthorityId.trim();
    }

    public String getThirdlyAuthorityName() {
        return thirdlyAuthorityName;
    }

    public void setThirdlyAuthorityName(String thirdlyAuthorityName) {
        this.thirdlyAuthorityName = thirdlyAuthorityName == null ? null : thirdlyAuthorityName.trim();
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
        sb.append(", thirdlyAuthorityId=").append(thirdlyAuthorityId);
        sb.append(", thirdlyAuthorityName=").append(thirdlyAuthorityName);
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
        ThirdlyAuthority other = (ThirdlyAuthority) that;
        return (this.getThirdlyAuthorityId() == null ? other.getThirdlyAuthorityId() == null : this.getThirdlyAuthorityId().equals(other.getThirdlyAuthorityId()))
            && (this.getThirdlyAuthorityName() == null ? other.getThirdlyAuthorityName() == null : this.getThirdlyAuthorityName().equals(other.getThirdlyAuthorityName()))
            && (this.getBelongto() == null ? other.getBelongto() == null : this.getBelongto().equals(other.getBelongto()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getThirdlyAuthorityId() == null) ? 0 : getThirdlyAuthorityId().hashCode());
        result = prime * result + ((getThirdlyAuthorityName() == null) ? 0 : getThirdlyAuthorityName().hashCode());
        result = prime * result + ((getBelongto() == null) ? 0 : getBelongto().hashCode());
        return result;
    }
}