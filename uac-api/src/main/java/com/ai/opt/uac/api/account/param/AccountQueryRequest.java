package com.ai.opt.uac.api.account.param;

import java.io.Serializable;

public class AccountQueryRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ’À∫≈ID(±ÿÃÓ)
	 */
	private Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
