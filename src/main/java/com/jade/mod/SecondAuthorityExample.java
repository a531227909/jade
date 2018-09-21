package com.jade.mod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SecondAuthorityExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SecondAuthorityExample() {
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

        public Criteria andSecondAuthorityIdIsNull() {
            addCriterion("second_authority_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdIsNotNull() {
            addCriterion("second_authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdEqualTo(String value) {
            addCriterion("second_authority_id =", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdNotEqualTo(String value) {
            addCriterion("second_authority_id <>", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdGreaterThan(String value) {
            addCriterion("second_authority_id >", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdGreaterThanOrEqualTo(String value) {
            addCriterion("second_authority_id >=", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdLessThan(String value) {
            addCriterion("second_authority_id <", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdLessThanOrEqualTo(String value) {
            addCriterion("second_authority_id <=", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdLike(String value) {
            addCriterion("second_authority_id like", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdNotLike(String value) {
            addCriterion("second_authority_id not like", value, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdIn(List<String> values) {
            addCriterion("second_authority_id in", values, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdNotIn(List<String> values) {
            addCriterion("second_authority_id not in", values, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdBetween(String value1, String value2) {
            addCriterion("second_authority_id between", value1, value2, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityIdNotBetween(String value1, String value2) {
            addCriterion("second_authority_id not between", value1, value2, "secondAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameIsNull() {
            addCriterion("second_authority_name is null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameIsNotNull() {
            addCriterion("second_authority_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameEqualTo(String value) {
            addCriterion("second_authority_name =", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameNotEqualTo(String value) {
            addCriterion("second_authority_name <>", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameGreaterThan(String value) {
            addCriterion("second_authority_name >", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("second_authority_name >=", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameLessThan(String value) {
            addCriterion("second_authority_name <", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("second_authority_name <=", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameLike(String value) {
            addCriterion("second_authority_name like", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameNotLike(String value) {
            addCriterion("second_authority_name not like", value, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameIn(List<String> values) {
            addCriterion("second_authority_name in", values, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameNotIn(List<String> values) {
            addCriterion("second_authority_name not in", values, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameBetween(String value1, String value2) {
            addCriterion("second_authority_name between", value1, value2, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("second_authority_name not between", value1, value2, "secondAuthorityName");
            return (Criteria) this;
        }

        public Criteria andBelongtoIsNull() {
            addCriterion("belongTo is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoIsNotNull() {
            addCriterion("belongTo is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoEqualTo(String value) {
            addCriterion("belongTo =", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotEqualTo(String value) {
            addCriterion("belongTo <>", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoGreaterThan(String value) {
            addCriterion("belongTo >", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoGreaterThanOrEqualTo(String value) {
            addCriterion("belongTo >=", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLessThan(String value) {
            addCriterion("belongTo <", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLessThanOrEqualTo(String value) {
            addCriterion("belongTo <=", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLike(String value) {
            addCriterion("belongTo like", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotLike(String value) {
            addCriterion("belongTo not like", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoIn(List<String> values) {
            addCriterion("belongTo in", values, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotIn(List<String> values) {
            addCriterion("belongTo not in", values, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoBetween(String value1, String value2) {
            addCriterion("belongTo between", value1, value2, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotBetween(String value1, String value2) {
            addCriterion("belongTo not between", value1, value2, "belongto");
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