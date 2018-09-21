package com.jade.mod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommodityExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIsNull() {
            addCriterion("second_category is null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIsNotNull() {
            addCriterion("second_category is not null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryEqualTo(String value) {
            addCriterion("second_category =", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotEqualTo(String value) {
            addCriterion("second_category <>", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryGreaterThan(String value) {
            addCriterion("second_category >", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("second_category >=", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryLessThan(String value) {
            addCriterion("second_category <", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryLessThanOrEqualTo(String value) {
            addCriterion("second_category <=", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryLike(String value) {
            addCriterion("second_category like", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotLike(String value) {
            addCriterion("second_category not like", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIn(List<String> values) {
            addCriterion("second_category in", values, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotIn(List<String> values) {
            addCriterion("second_category not in", values, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryBetween(String value1, String value2) {
            addCriterion("second_category between", value1, value2, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotBetween(String value1, String value2) {
            addCriterion("second_category not between", value1, value2, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Integer> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Integer> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeIsNull() {
            addCriterion("shelvesTime is null");
            return (Criteria) this;
        }

        public Criteria andShelvestimeIsNotNull() {
            addCriterion("shelvesTime is not null");
            return (Criteria) this;
        }

        public Criteria andShelvestimeEqualTo(Date value) {
            addCriterion("shelvesTime =", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeNotEqualTo(Date value) {
            addCriterion("shelvesTime <>", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeGreaterThan(Date value) {
            addCriterion("shelvesTime >", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shelvesTime >=", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeLessThan(Date value) {
            addCriterion("shelvesTime <", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeLessThanOrEqualTo(Date value) {
            addCriterion("shelvesTime <=", value, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeIn(List<Date> values) {
            addCriterion("shelvesTime in", values, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeNotIn(List<Date> values) {
            addCriterion("shelvesTime not in", values, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeBetween(Date value1, Date value2) {
            addCriterion("shelvesTime between", value1, value2, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andShelvestimeNotBetween(Date value1, Date value2) {
            addCriterion("shelvesTime not between", value1, value2, "shelvestime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeIsNull() {
            addCriterion("effectiveTime is null");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeIsNotNull() {
            addCriterion("effectiveTime is not null");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeEqualTo(Date value) {
            addCriterion("effectiveTime =", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeNotEqualTo(Date value) {
            addCriterion("effectiveTime <>", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeGreaterThan(Date value) {
            addCriterion("effectiveTime >", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("effectiveTime >=", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeLessThan(Date value) {
            addCriterion("effectiveTime <", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeLessThanOrEqualTo(Date value) {
            addCriterion("effectiveTime <=", value, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeIn(List<Date> values) {
            addCriterion("effectiveTime in", values, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeNotIn(List<Date> values) {
            addCriterion("effectiveTime not in", values, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeBetween(Date value1, Date value2) {
            addCriterion("effectiveTime between", value1, value2, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andEffectivetimeNotBetween(Date value1, Date value2) {
            addCriterion("effectiveTime not between", value1, value2, "effectivetime");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillIsNull() {
            addCriterion("isNoPackagemaill is null");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillIsNotNull() {
            addCriterion("isNoPackagemaill is not null");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillEqualTo(String value) {
            addCriterion("isNoPackagemaill =", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillNotEqualTo(String value) {
            addCriterion("isNoPackagemaill <>", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillGreaterThan(String value) {
            addCriterion("isNoPackagemaill >", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillGreaterThanOrEqualTo(String value) {
            addCriterion("isNoPackagemaill >=", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillLessThan(String value) {
            addCriterion("isNoPackagemaill <", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillLessThanOrEqualTo(String value) {
            addCriterion("isNoPackagemaill <=", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillLike(String value) {
            addCriterion("isNoPackagemaill like", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillNotLike(String value) {
            addCriterion("isNoPackagemaill not like", value, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillIn(List<String> values) {
            addCriterion("isNoPackagemaill in", values, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillNotIn(List<String> values) {
            addCriterion("isNoPackagemaill not in", values, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillBetween(String value1, String value2) {
            addCriterion("isNoPackagemaill between", value1, value2, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andIsnopackagemaillNotBetween(String value1, String value2) {
            addCriterion("isNoPackagemaill not between", value1, value2, "isnopackagemaill");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeIsNull() {
            addCriterion("standarddcscribe is null");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeIsNotNull() {
            addCriterion("standarddcscribe is not null");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeEqualTo(String value) {
            addCriterion("standarddcscribe =", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeNotEqualTo(String value) {
            addCriterion("standarddcscribe <>", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeGreaterThan(String value) {
            addCriterion("standarddcscribe >", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeGreaterThanOrEqualTo(String value) {
            addCriterion("standarddcscribe >=", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeLessThan(String value) {
            addCriterion("standarddcscribe <", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeLessThanOrEqualTo(String value) {
            addCriterion("standarddcscribe <=", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeLike(String value) {
            addCriterion("standarddcscribe like", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeNotLike(String value) {
            addCriterion("standarddcscribe not like", value, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeIn(List<String> values) {
            addCriterion("standarddcscribe in", values, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeNotIn(List<String> values) {
            addCriterion("standarddcscribe not in", values, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeBetween(String value1, String value2) {
            addCriterion("standarddcscribe between", value1, value2, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andStandarddcscribeNotBetween(String value1, String value2) {
            addCriterion("standarddcscribe not between", value1, value2, "standarddcscribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeIsNull() {
            addCriterion("figuredescribe is null");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeIsNotNull() {
            addCriterion("figuredescribe is not null");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeEqualTo(String value) {
            addCriterion("figuredescribe =", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeNotEqualTo(String value) {
            addCriterion("figuredescribe <>", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeGreaterThan(String value) {
            addCriterion("figuredescribe >", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeGreaterThanOrEqualTo(String value) {
            addCriterion("figuredescribe >=", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeLessThan(String value) {
            addCriterion("figuredescribe <", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeLessThanOrEqualTo(String value) {
            addCriterion("figuredescribe <=", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeLike(String value) {
            addCriterion("figuredescribe like", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeNotLike(String value) {
            addCriterion("figuredescribe not like", value, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeIn(List<String> values) {
            addCriterion("figuredescribe in", values, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeNotIn(List<String> values) {
            addCriterion("figuredescribe not in", values, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeBetween(String value1, String value2) {
            addCriterion("figuredescribe between", value1, value2, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andFiguredescribeNotBetween(String value1, String value2) {
            addCriterion("figuredescribe not between", value1, value2, "figuredescribe");
            return (Criteria) this;
        }

        public Criteria andCommodityimgIsNull() {
            addCriterion("commodityImg is null");
            return (Criteria) this;
        }

        public Criteria andCommodityimgIsNotNull() {
            addCriterion("commodityImg is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityimgEqualTo(String value) {
            addCriterion("commodityImg =", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgNotEqualTo(String value) {
            addCriterion("commodityImg <>", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgGreaterThan(String value) {
            addCriterion("commodityImg >", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgGreaterThanOrEqualTo(String value) {
            addCriterion("commodityImg >=", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgLessThan(String value) {
            addCriterion("commodityImg <", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgLessThanOrEqualTo(String value) {
            addCriterion("commodityImg <=", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgLike(String value) {
            addCriterion("commodityImg like", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgNotLike(String value) {
            addCriterion("commodityImg not like", value, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgIn(List<String> values) {
            addCriterion("commodityImg in", values, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgNotIn(List<String> values) {
            addCriterion("commodityImg not in", values, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgBetween(String value1, String value2) {
            addCriterion("commodityImg between", value1, value2, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andCommodityimgNotBetween(String value1, String value2) {
            addCriterion("commodityImg not between", value1, value2, "commodityimg");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("isdel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isdel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(String value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(String value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(String value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(String value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(String value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(String value) {
            addCriterion("isdel like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(String value) {
            addCriterion("isdel not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<String> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<String> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(String value1, String value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(String value1, String value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
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