package org.progingo.domain.subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("`key` is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("`key` is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("`key` =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("`key` <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("`key` >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("`key` >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("`key` <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("`key` <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("`key` like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("`key` not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("`key` in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("`key` not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("`key` between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("`key` not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIsNull() {
            addCriterion("resource_key is null");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIsNotNull() {
            addCriterion("resource_key is not null");
            return (Criteria) this;
        }

        public Criteria andResourceKeyEqualTo(String value) {
            addCriterion("resource_key =", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotEqualTo(String value) {
            addCriterion("resource_key <>", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyGreaterThan(String value) {
            addCriterion("resource_key >", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("resource_key >=", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLessThan(String value) {
            addCriterion("resource_key <", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLessThanOrEqualTo(String value) {
            addCriterion("resource_key <=", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyLike(String value) {
            addCriterion("resource_key like", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotLike(String value) {
            addCriterion("resource_key not like", value, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyIn(List<String> values) {
            addCriterion("resource_key in", values, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotIn(List<String> values) {
            addCriterion("resource_key not in", values, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyBetween(String value1, String value2) {
            addCriterion("resource_key between", value1, value2, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andResourceKeyNotBetween(String value1, String value2) {
            addCriterion("resource_key not between", value1, value2, "resourceKey");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andXx1IsNull() {
            addCriterion("xx1 is null");
            return (Criteria) this;
        }

        public Criteria andXx1IsNotNull() {
            addCriterion("xx1 is not null");
            return (Criteria) this;
        }

        public Criteria andXx1EqualTo(String value) {
            addCriterion("xx1 =", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1NotEqualTo(String value) {
            addCriterion("xx1 <>", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1GreaterThan(String value) {
            addCriterion("xx1 >", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1GreaterThanOrEqualTo(String value) {
            addCriterion("xx1 >=", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1LessThan(String value) {
            addCriterion("xx1 <", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1LessThanOrEqualTo(String value) {
            addCriterion("xx1 <=", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1Like(String value) {
            addCriterion("xx1 like", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1NotLike(String value) {
            addCriterion("xx1 not like", value, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1In(List<String> values) {
            addCriterion("xx1 in", values, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1NotIn(List<String> values) {
            addCriterion("xx1 not in", values, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1Between(String value1, String value2) {
            addCriterion("xx1 between", value1, value2, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx1NotBetween(String value1, String value2) {
            addCriterion("xx1 not between", value1, value2, "xx1");
            return (Criteria) this;
        }

        public Criteria andXx2IsNull() {
            addCriterion("xx2 is null");
            return (Criteria) this;
        }

        public Criteria andXx2IsNotNull() {
            addCriterion("xx2 is not null");
            return (Criteria) this;
        }

        public Criteria andXx2EqualTo(String value) {
            addCriterion("xx2 =", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2NotEqualTo(String value) {
            addCriterion("xx2 <>", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2GreaterThan(String value) {
            addCriterion("xx2 >", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2GreaterThanOrEqualTo(String value) {
            addCriterion("xx2 >=", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2LessThan(String value) {
            addCriterion("xx2 <", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2LessThanOrEqualTo(String value) {
            addCriterion("xx2 <=", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2Like(String value) {
            addCriterion("xx2 like", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2NotLike(String value) {
            addCriterion("xx2 not like", value, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2In(List<String> values) {
            addCriterion("xx2 in", values, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2NotIn(List<String> values) {
            addCriterion("xx2 not in", values, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2Between(String value1, String value2) {
            addCriterion("xx2 between", value1, value2, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx2NotBetween(String value1, String value2) {
            addCriterion("xx2 not between", value1, value2, "xx2");
            return (Criteria) this;
        }

        public Criteria andXx3IsNull() {
            addCriterion("xx3 is null");
            return (Criteria) this;
        }

        public Criteria andXx3IsNotNull() {
            addCriterion("xx3 is not null");
            return (Criteria) this;
        }

        public Criteria andXx3EqualTo(String value) {
            addCriterion("xx3 =", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3NotEqualTo(String value) {
            addCriterion("xx3 <>", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3GreaterThan(String value) {
            addCriterion("xx3 >", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3GreaterThanOrEqualTo(String value) {
            addCriterion("xx3 >=", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3LessThan(String value) {
            addCriterion("xx3 <", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3LessThanOrEqualTo(String value) {
            addCriterion("xx3 <=", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3Like(String value) {
            addCriterion("xx3 like", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3NotLike(String value) {
            addCriterion("xx3 not like", value, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3In(List<String> values) {
            addCriterion("xx3 in", values, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3NotIn(List<String> values) {
            addCriterion("xx3 not in", values, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3Between(String value1, String value2) {
            addCriterion("xx3 between", value1, value2, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx3NotBetween(String value1, String value2) {
            addCriterion("xx3 not between", value1, value2, "xx3");
            return (Criteria) this;
        }

        public Criteria andXx4IsNull() {
            addCriterion("xx4 is null");
            return (Criteria) this;
        }

        public Criteria andXx4IsNotNull() {
            addCriterion("xx4 is not null");
            return (Criteria) this;
        }

        public Criteria andXx4EqualTo(String value) {
            addCriterion("xx4 =", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4NotEqualTo(String value) {
            addCriterion("xx4 <>", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4GreaterThan(String value) {
            addCriterion("xx4 >", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4GreaterThanOrEqualTo(String value) {
            addCriterion("xx4 >=", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4LessThan(String value) {
            addCriterion("xx4 <", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4LessThanOrEqualTo(String value) {
            addCriterion("xx4 <=", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4Like(String value) {
            addCriterion("xx4 like", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4NotLike(String value) {
            addCriterion("xx4 not like", value, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4In(List<String> values) {
            addCriterion("xx4 in", values, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4NotIn(List<String> values) {
            addCriterion("xx4 not in", values, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4Between(String value1, String value2) {
            addCriterion("xx4 between", value1, value2, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx4NotBetween(String value1, String value2) {
            addCriterion("xx4 not between", value1, value2, "xx4");
            return (Criteria) this;
        }

        public Criteria andXx5IsNull() {
            addCriterion("xx5 is null");
            return (Criteria) this;
        }

        public Criteria andXx5IsNotNull() {
            addCriterion("xx5 is not null");
            return (Criteria) this;
        }

        public Criteria andXx5EqualTo(String value) {
            addCriterion("xx5 =", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5NotEqualTo(String value) {
            addCriterion("xx5 <>", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5GreaterThan(String value) {
            addCriterion("xx5 >", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5GreaterThanOrEqualTo(String value) {
            addCriterion("xx5 >=", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5LessThan(String value) {
            addCriterion("xx5 <", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5LessThanOrEqualTo(String value) {
            addCriterion("xx5 <=", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5Like(String value) {
            addCriterion("xx5 like", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5NotLike(String value) {
            addCriterion("xx5 not like", value, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5In(List<String> values) {
            addCriterion("xx5 in", values, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5NotIn(List<String> values) {
            addCriterion("xx5 not in", values, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5Between(String value1, String value2) {
            addCriterion("xx5 between", value1, value2, "xx5");
            return (Criteria) this;
        }

        public Criteria andXx5NotBetween(String value1, String value2) {
            addCriterion("xx5 not between", value1, value2, "xx5");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(Integer value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(Integer value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(Integer value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(Integer value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(Integer value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<Integer> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<Integer> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(Integer value1, Integer value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(Integer value1, Integer value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(String value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(String value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(String value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(String value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(String value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLike(String value) {
            addCriterion("analysis like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotLike(String value) {
            addCriterion("analysis not like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<String> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<String> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(String value1, String value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(String value1, String value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    /**
     */
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