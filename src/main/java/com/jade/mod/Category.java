package com.jade.mod;

import java.io.Serializable;

public class Category implements Serializable {
    private String id;

    private String name;

    private String showimg;

    private String stylrimg;

    private String firstId;

    private String reserve;

    private String reserve1;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShowimg() {
        return showimg;
    }

    public void setShowimg(String showimg) {
        this.showimg = showimg == null ? null : showimg.trim();
    }

    public String getStylrimg() {
        return stylrimg;
    }

    public void setStylrimg(String stylrimg) {
        this.stylrimg = stylrimg == null ? null : stylrimg.trim();
    }

    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId == null ? null : firstId.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", showimg=").append(showimg);
        sb.append(", stylrimg=").append(stylrimg);
        sb.append(", firstId=").append(firstId);
        sb.append(", reserve=").append(reserve);
        sb.append(", reserve1=").append(reserve1);
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
        Category other = (Category) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getShowimg() == null ? other.getShowimg() == null : this.getShowimg().equals(other.getShowimg()))
            && (this.getStylrimg() == null ? other.getStylrimg() == null : this.getStylrimg().equals(other.getStylrimg()))
            && (this.getFirstId() == null ? other.getFirstId() == null : this.getFirstId().equals(other.getFirstId()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()))
            && (this.getReserve1() == null ? other.getReserve1() == null : this.getReserve1().equals(other.getReserve1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getShowimg() == null) ? 0 : getShowimg().hashCode());
        result = prime * result + ((getStylrimg() == null) ? 0 : getStylrimg().hashCode());
        result = prime * result + ((getFirstId() == null) ? 0 : getFirstId().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        result = prime * result + ((getReserve1() == null) ? 0 : getReserve1().hashCode());
        return result;
    }
}