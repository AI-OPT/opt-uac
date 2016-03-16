package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountPasswordRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * �˺�ID�����
	 */
	private Long accountId;

	/**
	 * ���루���
	 */
	private String password;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
