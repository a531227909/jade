package com.jade.mod;

import java.io.Serializable;
import java.util.Date;

public class Commodity implements Serializable {
    private String cid;

    private String sid;

    private String name;

    private String categoryId;

    private String secondCategory;

    private Integer inventory;

    private Integer price;

    private Date createtime;

    private Date shelvestime;

    private Date effectivetime;

    private String size;

    private String color;

    private String isnopackagemaill;

    private String standarddcscribe;

    private String figuredescribe;

    private String commodityimg;

    private String status;

    private String isdel;

    private static final long serialVersionUID = 1L;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory == null ? null : secondCategory.trim();
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getShelvestime() {
        return shelvestime;
    }

    public void setShelvestime(Date shelvestime) {
        this.shelvestime = shelvestime;
    }

    public Date getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(Date effectivetime) {
        this.effectivetime = effectivetime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getIsnopackagemaill() {
        return isnopackagemaill;
    }

    public void setIsnopackagemaill(String isnopackagemaill) {
        this.isnopackagemaill = isnopackagemaill == null ? null : isnopackagemaill.trim();
    }

    public String getStandarddcscribe() {
        return standarddcscribe;
    }

    public void setStandarddcscribe(String standarddcscribe) {
        this.standarddcscribe = standarddcscribe == null ? null : standarddcscribe.trim();
    }

    public String getFiguredescribe() {
        return figuredescribe;
    }

    public void setFiguredescribe(String figuredescribe) {
        this.figuredescribe = figuredescribe == null ? null : figuredescribe.trim();
    }

    public String getCommodityimg() {
        return commodityimg;
    }

    public void setCommodityimg(String commodityimg) {
        this.commodityimg = commodityimg == null ? null : commodityimg.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", sid=").append(sid);
        sb.append(", name=").append(name);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", secondCategory=").append(secondCategory);
        sb.append(", inventory=").append(inventory);
        sb.append(", price=").append(price);
        sb.append(", createtime=").append(createtime);
        sb.append(", shelvestime=").append(shelvestime);
        sb.append(", effectivetime=").append(effectivetime);
        sb.append(", size=").append(size);
        sb.append(", color=").append(color);
        sb.append(", isnopackagemaill=").append(isnopackagemaill);
        sb.append(", standarddcscribe=").append(standarddcscribe);
        sb.append(", figuredescribe=").append(figuredescribe);
        sb.append(", commodityimg=").append(commodityimg);
        sb.append(", status=").append(status);
        sb.append(", isdel=").append(isdel);
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
        Commodity other = (Commodity) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getSecondCategory() == null ? other.getSecondCategory() == null : this.getSecondCategory().equals(other.getSecondCategory()))
            && (this.getInventory() == null ? other.getInventory() == null : this.getInventory().equals(other.getInventory()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getShelvestime() == null ? other.getShelvestime() == null : this.getShelvestime().equals(other.getShelvestime()))
            && (this.getEffectivetime() == null ? other.getEffectivetime() == null : this.getEffectivetime().equals(other.getEffectivetime()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getIsnopackagemaill() == null ? other.getIsnopackagemaill() == null : this.getIsnopackagemaill().equals(other.getIsnopackagemaill()))
            && (this.getStandarddcscribe() == null ? other.getStandarddcscribe() == null : this.getStandarddcscribe().equals(other.getStandarddcscribe()))
            && (this.getFiguredescribe() == null ? other.getFiguredescribe() == null : this.getFiguredescribe().equals(other.getFiguredescribe()))
            && (this.getCommodityimg() == null ? other.getCommodityimg() == null : this.getCommodityimg().equals(other.getCommodityimg()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getSecondCategory() == null) ? 0 : getSecondCategory().hashCode());
        result = prime * result + ((getInventory() == null) ? 0 : getInventory().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getShelvestime() == null) ? 0 : getShelvestime().hashCode());
        result = prime * result + ((getEffectivetime() == null) ? 0 : getEffectivetime().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getIsnopackagemaill() == null) ? 0 : getIsnopackagemaill().hashCode());
        result = prime * result + ((getStandarddcscribe() == null) ? 0 : getStandarddcscribe().hashCode());
        result = prime * result + ((getFiguredescribe() == null) ? 0 : getFiguredescribe().hashCode());
        result = prime * result + ((getCommodityimg() == null) ? 0 : getCommodityimg().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        return result;
    }
}