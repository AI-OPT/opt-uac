package com.ai.opt.uac.api.system.systenant.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class QueryTenantResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 公司名称
     */
    private String tenantName;

    /**
     * 公司类型
     */
    private String industryCode;

    /**
     * 状态
     */
    private String state;

    /**
     * 公司地址
     */
    private String tenantAddress;

    /**
     * 公司電話
     */
    private String tenantTelephone;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    /**
     * 創建人ID
     */
    private long createAccountId;

    /**
     * 修改人ID
     */
    private long updateAccountId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }

    public String getTenantTelephone() {
        return tenantTelephone;
    }

    public void setTenantTelephone(String tenantTelephone) {
        this.tenantTelephone = tenantTelephone;
    }

    public long getCreateAccountId() {
        return createAccountId;
    }

    public void setCreateAccountId(long createAccountId) {
        this.createAccountId = createAccountId;
    }

    public long getUpdateAccountId() {
        return updateAccountId;
    }

    public void setUpdateAccountId(long updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

    public Timestamp getCreateTime() {
        return createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = (createTime == null ? null : (Timestamp) createTime.clone());
    }

    public Timestamp getUpdateTime() {
        return updateTime == null ? null : (Timestamp) updateTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime == null ? null : (Timestamp) updateTime.clone());
    }
}
