package org.progingo.domain.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andProjectKeyIsNull() {
            addCriterion("project_key is null");
            return (Criteria) this;
        }

        public Criteria andProjectKeyIsNotNull() {
            addCriterion("project_key is not null");
            return (Criteria) this;
        }

        public Criteria andProjectKeyEqualTo(String value) {
            addCriterion("project_key =", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyNotEqualTo(String value) {
            addCriterion("project_key <>", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyGreaterThan(String value) {
            addCriterion("project_key >", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyGreaterThanOrEqualTo(String value) {
            addCriterion("project_key >=", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyLessThan(String value) {
            addCriterion("project_key <", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyLessThanOrEqualTo(String value) {
            addCriterion("project_key <=", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyLike(String value) {
            addCriterion("project_key like", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyNotLike(String value) {
            addCriterion("project_key not like", value, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyIn(List<String> values) {
            addCriterion("project_key in", values, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyNotIn(List<String> values) {
            addCriterion("project_key not in", values, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyBetween(String value1, String value2) {
            addCriterion("project_key between", value1, value2, "projectKey");
            return (Criteria) this;
        }

        public Criteria andProjectKeyNotBetween(String value1, String value2) {
            addCriterion("project_key not between", value1, value2, "projectKey");
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIsPrivateIsNull() {
            addCriterion("is_private is null");
            return (Criteria) this;
        }

        public Criteria andIsPrivateIsNotNull() {
            addCriterion("is_private is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrivateEqualTo(Boolean value) {
            addCriterion("is_private =", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateNotEqualTo(Boolean value) {
            addCriterion("is_private <>", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateGreaterThan(Boolean value) {
            addCriterion("is_private >", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_private >=", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateLessThan(Boolean value) {
            addCriterion("is_private <", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_private <=", value, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateIn(List<Boolean> values) {
            addCriterion("is_private in", values, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateNotIn(List<Boolean> values) {
            addCriterion("is_private not in", values, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_private between", value1, value2, "isPrivate");
            return (Criteria) this;
        }

        public Criteria andIsPrivateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_private not between", value1, value2, "isPrivate");
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

        public Criteria andGtmCreateIsNull() {
            addCriterion("gtm_create is null");
            return (Criteria) this;
        }

        public Criteria andGtmCreateIsNotNull() {
            addCriterion("gtm_create is not null");
            return (Criteria) this;
        }

        public Criteria andGtmCreateEqualTo(Date value) {
            addCriterion("gtm_create =", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateNotEqualTo(Date value) {
            addCriterion("gtm_create <>", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateGreaterThan(Date value) {
            addCriterion("gtm_create >", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gtm_create >=", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateLessThan(Date value) {
            addCriterion("gtm_create <", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateLessThanOrEqualTo(Date value) {
            addCriterion("gtm_create <=", value, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateIn(List<Date> values) {
            addCriterion("gtm_create in", values, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateNotIn(List<Date> values) {
            addCriterion("gtm_create not in", values, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateBetween(Date value1, Date value2) {
            addCriterion("gtm_create between", value1, value2, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmCreateNotBetween(Date value1, Date value2) {
            addCriterion("gtm_create not between", value1, value2, "gtmCreate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateIsNull() {
            addCriterion("gtm_update is null");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateIsNotNull() {
            addCriterion("gtm_update is not null");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateEqualTo(Date value) {
            addCriterion("gtm_update =", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateNotEqualTo(Date value) {
            addCriterion("gtm_update <>", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateGreaterThan(Date value) {
            addCriterion("gtm_update >", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("gtm_update >=", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateLessThan(Date value) {
            addCriterion("gtm_update <", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateLessThanOrEqualTo(Date value) {
            addCriterion("gtm_update <=", value, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateIn(List<Date> values) {
            addCriterion("gtm_update in", values, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateNotIn(List<Date> values) {
            addCriterion("gtm_update not in", values, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateBetween(Date value1, Date value2) {
            addCriterion("gtm_update between", value1, value2, "gtmUpdate");
            return (Criteria) this;
        }

        public Criteria andGtmUpdateNotBetween(Date value1, Date value2) {
            addCriterion("gtm_update not between", value1, value2, "gtmUpdate");
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