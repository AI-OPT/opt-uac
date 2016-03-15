package com.ai.opt.uac.dao.mapper.bo;

import java.sql.Timestamp;

public class GnTenant {
    private String tenantId;

    private String tenantName;

    private String state;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Long createAccountId;

    private Long updateAccountId;

    private String industryCode;

    private String tenantAddress;

    private String tenantTelephone;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName == null ? null : tenantName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateAccountId() {
        return createAccountId;
    }

    public void setCreateAccountId(Long createAccountId) {
        this.createAccountId = createAccountId;
    }

    public Long getUpdateAccountId() {
        return updateAccountId;
    }

    public void setUpdateAccountId(Long updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress == null ? null : tenantAddress.trim();
    }

    public String getTenantTelephone() {
        return tenantTelephone;
    }

    public void setTenantTelephone(String tenantTelephone) {
        this.tenantTelephone = tenantTelephone == null ? null : tenantTelephone.trim();
    }
}