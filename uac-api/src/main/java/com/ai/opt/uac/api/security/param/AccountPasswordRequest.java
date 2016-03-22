package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountPasswordRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID（必填）
	 */
	private Long accountId;

	/**
	 * 密码（必填）
	 */
	private String accountPassword;
	
	/**
	 * 更新人ID
	 */
	private Long updateAccountId;

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

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
}
