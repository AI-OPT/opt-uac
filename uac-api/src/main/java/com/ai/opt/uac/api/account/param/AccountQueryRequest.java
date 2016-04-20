package com.ai.opt.uac.api.account.param;

import java.io.Serializable;

public class AccountQueryRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID(必填)
	 */
	private Long accountId;
	/**
	 * 手机号码
	 */
	private String phone;
	private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
