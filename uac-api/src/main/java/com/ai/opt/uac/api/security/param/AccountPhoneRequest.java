package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountPhoneRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID（必填）
	 */
	private Long accountId;

	/**
	 * 手机号码（必填）
	 */
	private String phone;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}

}
