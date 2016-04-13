package com.ai.opt.uac.api.system.systenant.param;

import com.ai.opt.base.vo.BaseInfo;

public class UpdateTenantRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;

    private String tenantName;

    private String state;

    private Long updateAccountId;

    private String industryCode;

    private String tenantAddress;

    private String tenantTelephone;

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		this.industryCode = industryCode;
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
}
