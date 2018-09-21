package com.jade.mod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FirstAuthorityExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FirstAuthorityExample() {
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

        public Criteria andFirstAuthorityIdIsNull() {
            addCriterion("first_authority_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdIsNotNull() {
            addCriterion("first_authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdEqualTo(String value) {
            addCriterion("first_authority_id =", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdNotEqualTo(String value) {
            addCriterion("first_authority_id <>", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdGreaterThan(String value) {
            addCriterion("first_authority_id >", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdGreaterThanOrEqualTo(String value) {
            addCriterion("first_authority_id >=", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdLessThan(String value) {
            addCriterion("first_authority_id <", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdLessThanOrEqualTo(String value) {
            addCriterion("first_authority_id <=", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdLike(String value) {
            addCriterion("first_authority_id like", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdNotLike(String value) {
            addCriterion("first_authority_id not like", value, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdIn(List<String> values) {
            addCriterion("first_authority_id in", values, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdNotIn(List<String> values) {
            addCriterion("first_authority_id not in", values, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdBetween(String value1, String value2) {
            addCriterion("first_authority_id between", value1, value2, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityIdNotBetween(String value1, String value2) {
            addCriterion("first_authority_id not between", value1, value2, "firstAuthorityId");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameIsNull() {
            addCriterion("first_authority_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameIsNotNull() {
            addCriterion("first_authority_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameEqualTo(String value) {
            addCriterion("first_authority_name =", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameNotEqualTo(String value) {
            addCriterion("first_authority_name <>", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameGreaterThan(String value) {
            addCriterion("first_authority_name >", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_authority_name >=", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameLessThan(String value) {
            addCriterion("first_authority_name <", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("first_authority_name <=", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameLike(String value) {
            addCriterion("first_authority_name like", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameNotLike(String value) {
            addCriterion("first_authority_name not like", value, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameIn(List<String> values) {
            addCriterion("first_authority_name in", values, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameNotIn(List<String> values) {
            addCriterion("first_authority_name not in", values, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameBetween(String value1, String value2) {
            addCriterion("first_authority_name between", value1, value2, "firstAuthorityName");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("first_authority_name not between", value1, value2, "firstAuthorityName");
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