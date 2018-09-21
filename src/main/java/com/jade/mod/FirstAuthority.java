package com.jade.mod;

import java.io.Serializable;

public class FirstAuthority implements Serializable {
    private String firstAuthorityId;

    private String firstAuthorityName;

    private static final long serialVersionUID = 1L;

    public String getFirstAuthorityId() {
        return firstAuthorityId;
    }

    public void setFirstAuthorityId(String firstAuthorityId) {
        this.firstAuthorityId = firstAuthorityId == null ? null : firstAuthorityId.trim();
    }

    public String getFirstAuthorityName() {
        return firstAuthorityName;
    }

    public void setFirstAuthorityName(String firstAuthorityName) {
        this.firstAuthorityName = firstAuthorityName == null ? null : firstAuthorityName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", firstAuthorityId=").append(firstAuthorityId);
        sb.append(", firstAuthorityName=").append(firstAuthorityName);
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
        FirstAuthority other = (FirstAuthority) that;
        return (this.getFirstAuthorityId() == null ? other.getFirstAuthorityId() == null : this.getFirstAuthorityId().equals(other.getFirstAuthorityId()))
            && (this.getFirstAuthorityName() == null ? other.getFirstAuthorityName() == null : this.getFirstAuthorityName().equals(other.getFirstAuthorityName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFirstAuthorityId() == null) ? 0 : getFirstAuthorityId().hashCode());
        result = prime * result + ((getFirstAuthorityName() == null) ? 0 : getFirstAuthorityName().hashCode());
        return result;
    }
}