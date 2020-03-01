package com.library.entity;

import java.util.ArrayList;
import java.util.List;

public class ReadertypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReadertypeExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andReadertypeidIsNull() {
            addCriterion("readertypeid is null");
            return (Criteria) this;
        }

        public Criteria andReadertypeidIsNotNull() {
            addCriterion("readertypeid is not null");
            return (Criteria) this;
        }

        public Criteria andReadertypeidEqualTo(Integer value) {
            addCriterion("readertypeid =", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidNotEqualTo(Integer value) {
            addCriterion("readertypeid <>", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidGreaterThan(Integer value) {
            addCriterion("readertypeid >", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("readertypeid >=", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidLessThan(Integer value) {
            addCriterion("readertypeid <", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidLessThanOrEqualTo(Integer value) {
            addCriterion("readertypeid <=", value, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidIn(List<Integer> values) {
            addCriterion("readertypeid in", values, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidNotIn(List<Integer> values) {
            addCriterion("readertypeid not in", values, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidBetween(Integer value1, Integer value2) {
            addCriterion("readertypeid between", value1, value2, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("readertypeid not between", value1, value2, "readertypeid");
            return (Criteria) this;
        }

        public Criteria andReadertypenameIsNull() {
            addCriterion("readertypename is null");
            return (Criteria) this;
        }

        public Criteria andReadertypenameIsNotNull() {
            addCriterion("readertypename is not null");
            return (Criteria) this;
        }

        public Criteria andReadertypenameEqualTo(String value) {
            addCriterion("readertypename =", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameNotEqualTo(String value) {
            addCriterion("readertypename <>", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameGreaterThan(String value) {
            addCriterion("readertypename >", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameGreaterThanOrEqualTo(String value) {
            addCriterion("readertypename >=", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameLessThan(String value) {
            addCriterion("readertypename <", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameLessThanOrEqualTo(String value) {
            addCriterion("readertypename <=", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameLike(String value) {
            addCriterion("readertypename like", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameNotLike(String value) {
            addCriterion("readertypename not like", value, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameIn(List<String> values) {
            addCriterion("readertypename in", values, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameNotIn(List<String> values) {
            addCriterion("readertypename not in", values, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameBetween(String value1, String value2) {
            addCriterion("readertypename between", value1, value2, "readertypename");
            return (Criteria) this;
        }

        public Criteria andReadertypenameNotBetween(String value1, String value2) {
            addCriterion("readertypename not between", value1, value2, "readertypename");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumIsNull() {
            addCriterion("maxborrownum is null");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumIsNotNull() {
            addCriterion("maxborrownum is not null");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumEqualTo(Integer value) {
            addCriterion("maxborrownum =", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumNotEqualTo(Integer value) {
            addCriterion("maxborrownum <>", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumGreaterThan(Integer value) {
            addCriterion("maxborrownum >", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxborrownum >=", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumLessThan(Integer value) {
            addCriterion("maxborrownum <", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumLessThanOrEqualTo(Integer value) {
            addCriterion("maxborrownum <=", value, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumIn(List<Integer> values) {
            addCriterion("maxborrownum in", values, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumNotIn(List<Integer> values) {
            addCriterion("maxborrownum not in", values, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumBetween(Integer value1, Integer value2) {
            addCriterion("maxborrownum between", value1, value2, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andMaxborrownumNotBetween(Integer value1, Integer value2) {
            addCriterion("maxborrownum not between", value1, value2, "maxborrownum");
            return (Criteria) this;
        }

        public Criteria andBooklimitIsNull() {
            addCriterion("booklimit is null");
            return (Criteria) this;
        }

        public Criteria andBooklimitIsNotNull() {
            addCriterion("booklimit is not null");
            return (Criteria) this;
        }

        public Criteria andBooklimitEqualTo(Integer value) {
            addCriterion("booklimit =", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitNotEqualTo(Integer value) {
            addCriterion("booklimit <>", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitGreaterThan(Integer value) {
            addCriterion("booklimit >", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("booklimit >=", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitLessThan(Integer value) {
            addCriterion("booklimit <", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitLessThanOrEqualTo(Integer value) {
            addCriterion("booklimit <=", value, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitIn(List<Integer> values) {
            addCriterion("booklimit in", values, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitNotIn(List<Integer> values) {
            addCriterion("booklimit not in", values, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitBetween(Integer value1, Integer value2) {
            addCriterion("booklimit between", value1, value2, "booklimit");
            return (Criteria) this;
        }

        public Criteria andBooklimitNotBetween(Integer value1, Integer value2) {
            addCriterion("booklimit not between", value1, value2, "booklimit");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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