package com.ai.opt.uac.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GnTenantCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnTenantCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantNameIsNull() {
            addCriterion("tenant_name is null");
            return (Criteria) this;
        }

        public Criteria andTenantNameIsNotNull() {
            addCriterion("tenant_name is not null");
            return (Criteria) this;
        }

        public Criteria andTenantNameEqualTo(String value) {
            addCriterion("tenant_name =", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotEqualTo(String value) {
            addCriterion("tenant_name <>", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameGreaterThan(String value) {
            addCriterion("tenant_name >", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_name >=", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLessThan(String value) {
            addCriterion("tenant_name <", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLessThanOrEqualTo(String value) {
            addCriterion("tenant_name <=", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLike(String value) {
            addCriterion("tenant_name like", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotLike(String value) {
            addCriterion("tenant_name not like", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameIn(List<String> values) {
            addCriterion("tenant_name in", values, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotIn(List<String> values) {
            addCriterion("tenant_name not in", values, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameBetween(String value1, String value2) {
            addCriterion("tenant_name between", value1, value2, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotBetween(String value1, String value2) {
            addCriterion("tenant_name not between", value1, value2, "tenantName");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdIsNull() {
            addCriterion("create_account_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdIsNotNull() {
            addCriterion("create_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdEqualTo(Long value) {
            addCriterion("create_account_id =", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdNotEqualTo(Long value) {
            addCriterion("create_account_id <>", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdGreaterThan(Long value) {
            addCriterion("create_account_id >", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_account_id >=", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdLessThan(Long value) {
            addCriterion("create_account_id <", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("create_account_id <=", value, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdIn(List<Long> values) {
            addCriterion("create_account_id in", values, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdNotIn(List<Long> values) {
            addCriterion("create_account_id not in", values, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdBetween(Long value1, Long value2) {
            addCriterion("create_account_id between", value1, value2, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("create_account_id not between", value1, value2, "createAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdIsNull() {
            addCriterion("update_account_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdIsNotNull() {
            addCriterion("update_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdEqualTo(Long value) {
            addCriterion("update_account_id =", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdNotEqualTo(Long value) {
            addCriterion("update_account_id <>", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdGreaterThan(Long value) {
            addCriterion("update_account_id >", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_account_id >=", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdLessThan(Long value) {
            addCriterion("update_account_id <", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("update_account_id <=", value, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdIn(List<Long> values) {
            addCriterion("update_account_id in", values, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdNotIn(List<Long> values) {
            addCriterion("update_account_id not in", values, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdBetween(Long value1, Long value2) {
            addCriterion("update_account_id between", value1, value2, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("update_account_id not between", value1, value2, "updateAccountId");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("industry_code is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("industry_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("industry_code =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("industry_code <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("industry_code >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_code >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("industry_code <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("industry_code <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("industry_code like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("industry_code not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("industry_code in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("industry_code not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("industry_code between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("industry_code not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIsNull() {
            addCriterion("tenant_address is null");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIsNotNull() {
            addCriterion("tenant_address is not null");
            return (Criteria) this;
        }

        public Criteria andTenantAddressEqualTo(String value) {
            addCriterion("tenant_address =", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotEqualTo(String value) {
            addCriterion("tenant_address <>", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressGreaterThan(String value) {
            addCriterion("tenant_address >", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_address >=", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLessThan(String value) {
            addCriterion("tenant_address <", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLessThanOrEqualTo(String value) {
            addCriterion("tenant_address <=", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLike(String value) {
            addCriterion("tenant_address like", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotLike(String value) {
            addCriterion("tenant_address not like", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIn(List<String> values) {
            addCriterion("tenant_address in", values, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotIn(List<String> values) {
            addCriterion("tenant_address not in", values, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressBetween(String value1, String value2) {
            addCriterion("tenant_address between", value1, value2, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotBetween(String value1, String value2) {
            addCriterion("tenant_address not between", value1, value2, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneIsNull() {
            addCriterion("tenant_telephone is null");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneIsNotNull() {
            addCriterion("tenant_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneEqualTo(String value) {
            addCriterion("tenant_telephone =", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneNotEqualTo(String value) {
            addCriterion("tenant_telephone <>", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneGreaterThan(String value) {
            addCriterion("tenant_telephone >", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_telephone >=", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneLessThan(String value) {
            addCriterion("tenant_telephone <", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneLessThanOrEqualTo(String value) {
            addCriterion("tenant_telephone <=", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneLike(String value) {
            addCriterion("tenant_telephone like", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneNotLike(String value) {
            addCriterion("tenant_telephone not like", value, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneIn(List<String> values) {
            addCriterion("tenant_telephone in", values, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneNotIn(List<String> values) {
            addCriterion("tenant_telephone not in", values, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneBetween(String value1, String value2) {
            addCriterion("tenant_telephone between", value1, value2, "tenantTelephone");
            return (Criteria) this;
        }

        public Criteria andTenantTelephoneNotBetween(String value1, String value2) {
            addCriterion("tenant_telephone not between", value1, value2, "tenantTelephone");
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