package com.jade.mod;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private String noticeId;

    private String name;

    private String noticeCategory;

    private String noticeCategoryId;

    private Date createTime;

    private String comment;

    private String img;

    private String cid;

    private String online;

    private String firstNotice;

    private String secondNoice;

    private String reserve;

    private static final long serialVersionUID = 1L;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNoticeCategory() {
        return noticeCategory;
    }

    public void setNoticeCategory(String noticeCategory) {
        this.noticeCategory = noticeCategory == null ? null : noticeCategory.trim();
    }

    public String getNoticeCategoryId() {
        return noticeCategoryId;
    }

    public void setNoticeCategoryId(String noticeCategoryId) {
        this.noticeCategoryId = noticeCategoryId == null ? null : noticeCategoryId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online == null ? null : online.trim();
    }

    public String getFirstNotice() {
        return firstNotice;
    }

    public void setFirstNotice(String firstNotice) {
        this.firstNotice = firstNotice == null ? null : firstNotice.trim();
    }

    public String getSecondNoice() {
        return secondNoice;
    }

    public void setSecondNoice(String secondNoice) {
        this.secondNoice = secondNoice == null ? null : secondNoice.trim();
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
        sb.append(", noticeId=").append(noticeId);
        sb.append(", name=").append(name);
        sb.append(", noticeCategory=").append(noticeCategory);
        sb.append(", noticeCategoryId=").append(noticeCategoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", comment=").append(comment);
        sb.append(", img=").append(img);
        sb.append(", cid=").append(cid);
        sb.append(", online=").append(online);
        sb.append(", firstNotice=").append(firstNotice);
        sb.append(", secondNoice=").append(secondNoice);
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
        Notice other = (Notice) that;
        return (this.getNoticeId() == null ? other.getNoticeId() == null : this.getNoticeId().equals(other.getNoticeId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNoticeCategory() == null ? other.getNoticeCategory() == null : this.getNoticeCategory().equals(other.getNoticeCategory()))
            && (this.getNoticeCategoryId() == null ? other.getNoticeCategoryId() == null : this.getNoticeCategoryId().equals(other.getNoticeCategoryId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getOnline() == null ? other.getOnline() == null : this.getOnline().equals(other.getOnline()))
            && (this.getFirstNotice() == null ? other.getFirstNotice() == null : this.getFirstNotice().equals(other.getFirstNotice()))
            && (this.getSecondNoice() == null ? other.getSecondNoice() == null : this.getSecondNoice().equals(other.getSecondNoice()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeId() == null) ? 0 : getNoticeId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNoticeCategory() == null) ? 0 : getNoticeCategory().hashCode());
        result = prime * result + ((getNoticeCategoryId() == null) ? 0 : getNoticeCategoryId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getOnline() == null) ? 0 : getOnline().hashCode());
        result = prime * result + ((getFirstNotice() == null) ? 0 : getFirstNotice().hashCode());
        result = prime * result + ((getSecondNoice() == null) ? 0 : getSecondNoice().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        return result;
    }
}