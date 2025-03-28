package org.progingo.domain.ppt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PptInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PptInfoExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIsNull() {
            addCriterion("node_key is null");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIsNotNull() {
            addCriterion("node_key is not null");
            return (Criteria) this;
        }

        public Criteria andNodeKeyEqualTo(String value) {
            addCriterion("node_key =", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotEqualTo(String value) {
            addCriterion("node_key <>", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyGreaterThan(String value) {
            addCriterion("node_key >", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("node_key >=", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLessThan(String value) {
            addCriterion("node_key <", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLessThanOrEqualTo(String value) {
            addCriterion("node_key <=", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyLike(String value) {
            addCriterion("node_key like", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotLike(String value) {
            addCriterion("node_key not like", value, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyIn(List<String> values) {
            addCriterion("node_key in", values, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotIn(List<String> values) {
            addCriterion("node_key not in", values, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyBetween(String value1, String value2) {
            addCriterion("node_key between", value1, value2, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andNodeKeyNotBetween(String value1, String value2) {
            addCriterion("node_key not between", value1, value2, "nodeKey");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
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

        public Criteria andSlidesIsNull() {
            addCriterion("slides is null");
            return (Criteria) this;
        }

        public Criteria andSlidesIsNotNull() {
            addCriterion("slides is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesEqualTo(String value) {
            addCriterion("slides =", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesNotEqualTo(String value) {
            addCriterion("slides <>", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesGreaterThan(String value) {
            addCriterion("slides >", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesGreaterThanOrEqualTo(String value) {
            addCriterion("slides >=", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesLessThan(String value) {
            addCriterion("slides <", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesLessThanOrEqualTo(String value) {
            addCriterion("slides <=", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesLike(String value) {
            addCriterion("slides like", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesNotLike(String value) {
            addCriterion("slides not like", value, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesIn(List<String> values) {
            addCriterion("slides in", values, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesNotIn(List<String> values) {
            addCriterion("slides not in", values, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesBetween(String value1, String value2) {
            addCriterion("slides between", value1, value2, "slides");
            return (Criteria) this;
        }

        public Criteria andSlidesNotBetween(String value1, String value2) {
            addCriterion("slides not between", value1, value2, "slides");
            return (Criteria) this;
        }

        public Criteria andViewportsizeIsNull() {
            addCriterion("viewportSize is null");
            return (Criteria) this;
        }

        public Criteria andViewportsizeIsNotNull() {
            addCriterion("viewportSize is not null");
            return (Criteria) this;
        }

        public Criteria andViewportsizeEqualTo(String value) {
            addCriterion("viewportSize =", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeNotEqualTo(String value) {
            addCriterion("viewportSize <>", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeGreaterThan(String value) {
            addCriterion("viewportSize >", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeGreaterThanOrEqualTo(String value) {
            addCriterion("viewportSize >=", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeLessThan(String value) {
            addCriterion("viewportSize <", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeLessThanOrEqualTo(String value) {
            addCriterion("viewportSize <=", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeLike(String value) {
            addCriterion("viewportSize like", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeNotLike(String value) {
            addCriterion("viewportSize not like", value, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeIn(List<String> values) {
            addCriterion("viewportSize in", values, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeNotIn(List<String> values) {
            addCriterion("viewportSize not in", values, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeBetween(String value1, String value2) {
            addCriterion("viewportSize between", value1, value2, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportsizeNotBetween(String value1, String value2) {
            addCriterion("viewportSize not between", value1, value2, "viewportsize");
            return (Criteria) this;
        }

        public Criteria andViewportratioIsNull() {
            addCriterion("viewportRatio is null");
            return (Criteria) this;
        }

        public Criteria andViewportratioIsNotNull() {
            addCriterion("viewportRatio is not null");
            return (Criteria) this;
        }

        public Criteria andViewportratioEqualTo(String value) {
            addCriterion("viewportRatio =", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioNotEqualTo(String value) {
            addCriterion("viewportRatio <>", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioGreaterThan(String value) {
            addCriterion("viewportRatio >", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioGreaterThanOrEqualTo(String value) {
            addCriterion("viewportRatio >=", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioLessThan(String value) {
            addCriterion("viewportRatio <", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioLessThanOrEqualTo(String value) {
            addCriterion("viewportRatio <=", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioLike(String value) {
            addCriterion("viewportRatio like", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioNotLike(String value) {
            addCriterion("viewportRatio not like", value, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioIn(List<String> values) {
            addCriterion("viewportRatio in", values, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioNotIn(List<String> values) {
            addCriterion("viewportRatio not in", values, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioBetween(String value1, String value2) {
            addCriterion("viewportRatio between", value1, value2, "viewportratio");
            return (Criteria) this;
        }

        public Criteria andViewportratioNotBetween(String value1, String value2) {
            addCriterion("viewportRatio not between", value1, value2, "viewportratio");
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

        public Criteria andGmtUpdateIsNull() {
            addCriterion("gmt_update is null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIsNotNull() {
            addCriterion("gmt_update is not null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateEqualTo(Date value) {
            addCriterion("gmt_update =", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotEqualTo(Date value) {
            addCriterion("gmt_update <>", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateGreaterThan(Date value) {
            addCriterion("gmt_update >", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_update >=", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThan(Date value) {
            addCriterion("gmt_update <", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_update <=", value, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateIn(List<Date> values) {
            addCriterion("gmt_update in", values, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotIn(List<Date> values) {
            addCriterion("gmt_update not in", values, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateBetween(Date value1, Date value2) {
            addCriterion("gmt_update between", value1, value2, "gmtUpdate");
            return (Criteria) this;
        }

        public Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_update not between", value1, value2, "gmtUpdate");
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