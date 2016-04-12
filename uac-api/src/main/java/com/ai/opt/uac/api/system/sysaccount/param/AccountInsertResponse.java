package com.ai.opt.uac.api.system.sysaccount.param;

import com.ai.opt.base.vo.BaseResponse;

public class AccountInsertResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;

	private Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}
