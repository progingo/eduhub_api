package org.progingo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PptGitTreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PptGitTreeExample() {
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andPptKeyIsNull() {
            addCriterion("ppt_key is null");
            return (Criteria) this;
        }

        public Criteria andPptKeyIsNotNull() {
            addCriterion("ppt_key is not null");
            return (Criteria) this;
        }

        public Criteria andPptKeyEqualTo(String value) {
            addCriterion("ppt_key =", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyNotEqualTo(String value) {
            addCriterion("ppt_key <>", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyGreaterThan(String value) {
            addCriterion("ppt_key >", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ppt_key >=", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyLessThan(String value) {
            addCriterion("ppt_key <", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyLessThanOrEqualTo(String value) {
            addCriterion("ppt_key <=", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyLike(String value) {
            addCriterion("ppt_key like", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyNotLike(String value) {
            addCriterion("ppt_key not like", value, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyIn(List<String> values) {
            addCriterion("ppt_key in", values, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyNotIn(List<String> values) {
            addCriterion("ppt_key not in", values, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyBetween(String value1, String value2) {
            addCriterion("ppt_key between", value1, value2, "pptKey");
            return (Criteria) this;
        }

        public Criteria andPptKeyNotBetween(String value1, String value2) {
            addCriterion("ppt_key not between", value1, value2, "pptKey");
            return (Criteria) this;
        }

        public Criteria andIsRootIsNull() {
            addCriterion("is_root is null");
            return (Criteria) this;
        }

        public Criteria andIsRootIsNotNull() {
            addCriterion("is_root is not null");
            return (Criteria) this;
        }

        public Criteria andIsRootEqualTo(Boolean value) {
            addCriterion("is_root =", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotEqualTo(Boolean value) {
            addCriterion("is_root <>", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThan(Boolean value) {
            addCriterion("is_root >", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_root >=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThan(Boolean value) {
            addCriterion("is_root <", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThanOrEqualTo(Boolean value) {
            addCriterion("is_root <=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootIn(List<Boolean> values) {
            addCriterion("is_root in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotIn(List<Boolean> values) {
            addCriterion("is_root not in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootBetween(Boolean value1, Boolean value2) {
            addCriterion("is_root between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_root not between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("`operation` is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("`operation` is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(Integer value) {
            addCriterion("`operation` =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(Integer value) {
            addCriterion("`operation` <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(Integer value) {
            addCriterion("`operation` >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(Integer value) {
            addCriterion("`operation` >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(Integer value) {
            addCriterion("`operation` <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(Integer value) {
            addCriterion("`operation` <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<Integer> values) {
            addCriterion("`operation` in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<Integer> values) {
            addCriterion("`operation` not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(Integer value1, Integer value2) {
            addCriterion("`operation` between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(Integer value1, Integer value2) {
            addCriterion("`operation` not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andParentKeyIsNull() {
            addCriterion("parent_key is null");
            return (Criteria) this;
        }

        public Criteria andParentKeyIsNotNull() {
            addCriterion("parent_key is not null");
            return (Criteria) this;
        }

        public Criteria andParentKeyEqualTo(String value) {
            addCriterion("parent_key =", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyNotEqualTo(String value) {
            addCriterion("parent_key <>", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyGreaterThan(String value) {
            addCriterion("parent_key >", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyGreaterThanOrEqualTo(String value) {
            addCriterion("parent_key >=", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyLessThan(String value) {
            addCriterion("parent_key <", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyLessThanOrEqualTo(String value) {
            addCriterion("parent_key <=", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyLike(String value) {
            addCriterion("parent_key like", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyNotLike(String value) {
            addCriterion("parent_key not like", value, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyIn(List<String> values) {
            addCriterion("parent_key in", values, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyNotIn(List<String> values) {
            addCriterion("parent_key not in", values, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyBetween(String value1, String value2) {
            addCriterion("parent_key between", value1, value2, "parentKey");
            return (Criteria) this;
        }

        public Criteria andParentKeyNotBetween(String value1, String value2) {
            addCriterion("parent_key not between", value1, value2, "parentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyIsNull() {
            addCriterion("merge_parent_key is null");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyIsNotNull() {
            addCriterion("merge_parent_key is not null");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyEqualTo(String value) {
            addCriterion("merge_parent_key =", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyNotEqualTo(String value) {
            addCriterion("merge_parent_key <>", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyGreaterThan(String value) {
            addCriterion("merge_parent_key >", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyGreaterThanOrEqualTo(String value) {
            addCriterion("merge_parent_key >=", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyLessThan(String value) {
            addCriterion("merge_parent_key <", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyLessThanOrEqualTo(String value) {
            addCriterion("merge_parent_key <=", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyLike(String value) {
            addCriterion("merge_parent_key like", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyNotLike(String value) {
            addCriterion("merge_parent_key not like", value, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyIn(List<String> values) {
            addCriterion("merge_parent_key in", values, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyNotIn(List<String> values) {
            addCriterion("merge_parent_key not in", values, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyBetween(String value1, String value2) {
            addCriterion("merge_parent_key between", value1, value2, "mergeParentKey");
            return (Criteria) this;
        }

        public Criteria andMergeParentKeyNotBetween(String value1, String value2) {
            addCriterion("merge_parent_key not between", value1, value2, "mergeParentKey");
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