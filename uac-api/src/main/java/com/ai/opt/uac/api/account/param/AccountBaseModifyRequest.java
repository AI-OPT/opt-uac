package com.ai.opt.uac.api.account.param;

import java.io.Serializable;

public class AccountBaseModifyRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * �˺�ID(����)
	 */
	private Long accountId;

	/**
	 * �ǳ�(����)
	 */
    private String nickName;
    
    /**
     * �޸���ID(����)
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
