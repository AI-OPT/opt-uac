package com.ai.opt.uac.api.account.param;

import java.io.Serializable;

public class AccountTenantModifyRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID(必填)
	 */
	private Long accountId;

	/**
	 * 租户ID(必填)
	 */
    private String tenantId;
    
    /**
     * 修改人ID(必填)
     */
    private Long updateAccountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}

}
