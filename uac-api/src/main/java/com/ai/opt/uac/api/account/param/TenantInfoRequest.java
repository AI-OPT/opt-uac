package com.ai.opt.uac.api.account.param;

import com.ai.opt.base.vo.BaseInfo;

public class TenantInfoRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 公司名称(必填)
	 */
	private String tenantName;
	
	/**
	 * 公司类型(必填)
	 */
	private String industryCode;
	
	/**
	 * 账户ID(必填)
	 */
	private Long accountId;
	
	/**
	 * 修改人ID(必填)
	 */
	private Long updateAccountId;
	
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

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}
}
