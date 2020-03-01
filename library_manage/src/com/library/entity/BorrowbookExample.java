package com.library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BorrowbookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowbookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReaderkeyIsNull() {
            addCriterion("readerkey is null");
            return (Criteria) this;
        }

        public Criteria andReaderkeyIsNotNull() {
            addCriterion("readerkey is not null");
            return (Criteria) this;
        }

        public Criteria andReaderkeyEqualTo(String value) {
            addCriterion("readerkey =", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyNotEqualTo(String value) {
            addCriterion("readerkey <>", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyGreaterThan(String value) {
            addCriterion("readerkey >", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyGreaterThanOrEqualTo(String value) {
            addCriterion("readerkey >=", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyLessThan(String value) {
            addCriterion("readerkey <", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyLessThanOrEqualTo(String value) {
            addCriterion("readerkey <=", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyLike(String value) {
            addCriterion("readerkey like", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyNotLike(String value) {
            addCriterion("readerkey not like", value, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyIn(List<String> values) {
            addCriterion("readerkey in", values, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyNotIn(List<String> values) {
            addCriterion("readerkey not in", values, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyBetween(String value1, String value2) {
            addCriterion("readerkey between", value1, value2, "readerkey");
            return (Criteria) this;
        }

        public Criteria andReaderkeyNotBetween(String value1, String value2) {
            addCriterion("readerkey not between", value1, value2, "readerkey");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andBooktypeidIsNull() {
            addCriterion("booktypeid is null");
            return (Criteria) this;
        }

        public Criteria andBooktypeidIsNotNull() {
            addCriterion("booktypeid is not null");
            return (Criteria) this;
        }

        public Criteria andBooktypeidEqualTo(Integer value) {
            addCriterion("booktypeid =", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidNotEqualTo(Integer value) {
            addCriterion("booktypeid <>", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidGreaterThan(Integer value) {
            addCriterion("booktypeid >", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("booktypeid >=", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidLessThan(Integer value) {
            addCriterion("booktypeid <", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidLessThanOrEqualTo(Integer value) {
            addCriterion("booktypeid <=", value, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidIn(List<Integer> values) {
            addCriterion("booktypeid in", values, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidNotIn(List<Integer> values) {
            addCriterion("booktypeid not in", values, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidBetween(Integer value1, Integer value2) {
            addCriterion("booktypeid between", value1, value2, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBooktypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("booktypeid not between", value1, value2, "booktypeid");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNull() {
            addCriterion("borrowdate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNotNull() {
            addCriterion("borrowdate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate =", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <>", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThan(Date value) {
            addCriterionForJDBCDate("borrowdate >", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate >=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThan(Date value) {
            addCriterionForJDBCDate("borrowdate <", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate not in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate not between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateIsNull() {
            addCriterion("realreturndate is null");
            return (Criteria) this;
        }

        public Criteria andRealreturndateIsNotNull() {
            addCriterion("realreturndate is not null");
            return (Criteria) this;
        }

        public Criteria andRealreturndateEqualTo(Date value) {
            addCriterionForJDBCDate("realreturndate =", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("realreturndate <>", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateGreaterThan(Date value) {
            addCriterionForJDBCDate("realreturndate >", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realreturndate >=", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateLessThan(Date value) {
            addCriterionForJDBCDate("realreturndate <", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realreturndate <=", value, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateIn(List<Date> values) {
            addCriterionForJDBCDate("realreturndate in", values, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("realreturndate not in", values, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realreturndate between", value1, value2, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andRealreturndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realreturndate not between", value1, value2, "realreturndate");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNull() {
            addCriterion("returndate is null");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNotNull() {
            addCriterion("returndate is not null");
            return (Criteria) this;
        }

        public Criteria andReturndateEqualTo(Date value) {
            addCriterionForJDBCDate("returndate =", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("returndate <>", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThan(Date value) {
            addCriterionForJDBCDate("returndate >", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("returndate >=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThan(Date value) {
            addCriterionForJDBCDate("returndate <", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("returndate <=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateIn(List<Date> values) {
            addCriterionForJDBCDate("returndate in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("returndate not in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("returndate between", value1, value2, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("returndate not between", value1, value2, "returndate");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("fine is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("fine is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(Long value) {
            addCriterion("fine =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(Long value) {
            addCriterion("fine <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(Long value) {
            addCriterion("fine >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(Long value) {
            addCriterion("fine >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(Long value) {
            addCriterion("fine <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(Long value) {
            addCriterion("fine <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<Long> values) {
            addCriterion("fine in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<Long> values) {
            addCriterion("fine not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(Long value1, Long value2) {
            addCriterion("fine between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(Long value1, Long value2) {
            addCriterion("fine not between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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