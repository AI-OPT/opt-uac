package com.ai.opt.uac.api.security.param;

import java.io.Serializable;

public class AccountPhoneRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ’À∫≈ID£®±ÿÃÓ£©
	 */
	private Long accountId;

	/**
	 * ” œ‰£®±ÿÃÓ£©
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
