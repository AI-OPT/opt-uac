package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountEmailRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * �˺�ID�����
	 */
	private Long accountId;

	/**
	 * �ֻ����루���
	 */
	private String phone;

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

}
