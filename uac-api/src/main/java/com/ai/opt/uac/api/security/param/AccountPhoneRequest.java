package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountPhoneRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * �˺�ID�����
	 */
	private Long accountId;

	/**
	 * ���䣨���
	 */
	private String email;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
