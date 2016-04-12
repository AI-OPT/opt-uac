package com.ai.opt.uac.api.system.sysaccount.param;

import com.ai.opt.base.vo.BaseInfo;

public class AccountInfoQueryRequest extends BaseInfo{
	
	private static final long serialVersionUID = 1L;
	
	private Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}
