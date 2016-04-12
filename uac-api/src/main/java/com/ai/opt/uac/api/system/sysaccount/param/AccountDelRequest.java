package com.ai.opt.uac.api.system.sysaccount.param;

import com.ai.opt.base.vo.BaseInfo;

public class AccountDelRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	private Long accountId;
	
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

}
