package com.ai.opt.uac.api.account.param;

import java.io.Serializable;

public class AccountBaseModifyRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID(必填)
	 */
	private Long accountId;

	/**
	 * 昵称(必填)
	 */
    private String nickName;
    
    /**
     * 修改人ID(必填)
     */
    private Long updateAccountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}

}
