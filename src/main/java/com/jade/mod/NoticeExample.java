package com.jade.mod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public NoticeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(String value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(String value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(String value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(String value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(String value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(String value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLike(String value) {
            addCriterion("notice_id like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotLike(String value) {
            addCriterion("notice_id not like", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<String> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<String> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(String value1, String value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(String value1, String value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIsNull() {
            addCriterion("notice_category is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIsNotNull() {
            addCriterion("notice_category is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryEqualTo(String value) {
            addCriterion("notice_category =", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryNotEqualTo(String value) {
            addCriterion("notice_category <>", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryGreaterThan(String value) {
            addCriterion("notice_category >", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("notice_category >=", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryLessThan(String value) {
            addCriterion("notice_category <", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryLessThanOrEqualTo(String value) {
            addCriterion("notice_category <=", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryLike(String value) {
            addCriterion("notice_category like", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryNotLike(String value) {
            addCriterion("notice_category not like", value, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIn(List<String> values) {
            addCriterion("notice_category in", values, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryNotIn(List<String> values) {
            addCriterion("notice_category not in", values, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryBetween(String value1, String value2) {
            addCriterion("notice_category between", value1, value2, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryNotBetween(String value1, String value2) {
            addCriterion("notice_category not between", value1, value2, "noticeCategory");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdIsNull() {
            addCriterion("notice_category_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdIsNotNull() {
            addCriterion("notice_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdEqualTo(String value) {
            addCriterion("notice_category_id =", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdNotEqualTo(String value) {
            addCriterion("notice_category_id <>", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdGreaterThan(String value) {
            addCriterion("notice_category_id >", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("notice_category_id >=", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdLessThan(String value) {
            addCriterion("notice_category_id <", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("notice_category_id <=", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdLike(String value) {
            addCriterion("notice_category_id like", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdNotLike(String value) {
            addCriterion("notice_category_id not like", value, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdIn(List<String> values) {
            addCriterion("notice_category_id in", values, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdNotIn(List<String> values) {
            addCriterion("notice_category_id not in", values, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdBetween(String value1, String value2) {
            addCriterion("notice_category_id between", value1, value2, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andNoticeCategoryIdNotBetween(String value1, String value2) {
            addCriterion("notice_category_id not between", value1, value2, "noticeCategoryId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(String value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(String value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(String value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(String value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(String value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLike(String value) {
            addCriterion("online like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotLike(String value) {
            addCriterion("online not like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<String> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<String> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(String value1, String value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(String value1, String value2) {
            addCriterion("online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeIsNull() {
            addCriterion("first_notice is null");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeIsNotNull() {
            addCriterion("first_notice is not null");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeEqualTo(String value) {
            addCriterion("first_notice =", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeNotEqualTo(String value) {
            addCriterion("first_notice <>", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeGreaterThan(String value) {
            addCriterion("first_notice >", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("first_notice >=", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeLessThan(String value) {
            addCriterion("first_notice <", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeLessThanOrEqualTo(String value) {
            addCriterion("first_notice <=", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeLike(String value) {
            addCriterion("first_notice like", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeNotLike(String value) {
            addCriterion("first_notice not like", value, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeIn(List<String> values) {
            addCriterion("first_notice in", values, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeNotIn(List<String> values) {
            addCriterion("first_notice not in", values, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeBetween(String value1, String value2) {
            addCriterion("first_notice between", value1, value2, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andFirstNoticeNotBetween(String value1, String value2) {
            addCriterion("first_notice not between", value1, value2, "firstNotice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceIsNull() {
            addCriterion("second_noice is null");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceIsNotNull() {
            addCriterion("second_noice is not null");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceEqualTo(String value) {
            addCriterion("second_noice =", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceNotEqualTo(String value) {
            addCriterion("second_noice <>", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceGreaterThan(String value) {
            addCriterion("second_noice >", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceGreaterThanOrEqualTo(String value) {
            addCriterion("second_noice >=", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceLessThan(String value) {
            addCriterion("second_noice <", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceLessThanOrEqualTo(String value) {
            addCriterion("second_noice <=", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceLike(String value) {
            addCriterion("second_noice like", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceNotLike(String value) {
            addCriterion("second_noice not like", value, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceIn(List<String> values) {
            addCriterion("second_noice in", values, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceNotIn(List<String> values) {
            addCriterion("second_noice not in", values, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceBetween(String value1, String value2) {
            addCriterion("second_noice between", value1, value2, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andSecondNoiceNotBetween(String value1, String value2) {
            addCriterion("second_noice not between", value1, value2, "secondNoice");
            return (Criteria) this;
        }

        public Criteria andReserveIsNull() {
            addCriterion("reserve is null");
            return (Criteria) this;
        }

        public Criteria andReserveIsNotNull() {
            addCriterion("reserve is not null");
            return (Criteria) this;
        }

        public Criteria andReserveEqualTo(String value) {
            addCriterion("reserve =", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotEqualTo(String value) {
            addCriterion("reserve <>", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThan(String value) {
            addCriterion("reserve >", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThanOrEqualTo(String value) {
            addCriterion("reserve >=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThan(String value) {
            addCriterion("reserve <", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThanOrEqualTo(String value) {
            addCriterion("reserve <=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLike(String value) {
            addCriterion("reserve like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotLike(String value) {
            addCriterion("reserve not like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveIn(List<String> values) {
            addCriterion("reserve in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotIn(List<String> values) {
            addCriterion("reserve not in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveBetween(String value1, String value2) {
            addCriterion("reserve between", value1, value2, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotBetween(String value1, String value2) {
            addCriterion("reserve not between", value1, value2, "reserve");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}