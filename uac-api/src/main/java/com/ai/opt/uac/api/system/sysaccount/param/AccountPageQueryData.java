package com.ai.opt.uac.api.system.sysaccount.param;

import java.io.Serializable;


public class AccountPageQueryData implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tenantId;
	/**账号ID*/
	private Long accountId;
    /**昵称*/
    private String nickName;
    /**手机号*/
    private String phone;
    /**邮箱*/
    private String email;
    /**账号类型*/
    private String accountType;
    /**账号级别*/
    private String accountLevel;

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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
