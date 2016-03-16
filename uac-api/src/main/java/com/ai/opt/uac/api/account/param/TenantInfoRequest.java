package com.ai.opt.uac.api.account.param;

import com.ai.opt.base.vo.BaseInfo;

public class TenantInfoRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��˾����(����)
	 */
	private String tenantName;
	
	/**
	 * ��˾����(����)
	 */
	private String industryCode;
	
	/**
	 * ������ID(����)
	 */
	private Long createAccountId;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCreateAccountId() {
		return createAccountId;
	}

	public void setCreateAccountId(Long createAccountId) {
		this.createAccountId = createAccountId;
	}
}
