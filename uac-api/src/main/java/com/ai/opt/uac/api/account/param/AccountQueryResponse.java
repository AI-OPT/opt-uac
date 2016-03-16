package com.ai.opt.uac.api.account.param;

import com.ai.opt.base.vo.BaseResponse;

public class AccountQueryResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	/**
	 * �˺�ID
	 */
	private Long accountId;

	/**
	 * �⻧ID
	 */
    private String tenantId;

    /**
     * �ǳ�
     */
    private String nickName;

    /**
     * �ֻ�����
     */
    private String phone;
    
    /**
     * ����
     */
    private String email;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
