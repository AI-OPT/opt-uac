package com.ai.opt.uac.api.system.sysaccount.param;

import com.ai.opt.base.vo.BaseInfo;

public class AccountPageQueryRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	/**登录名称*/
	private String userName;
	/**账户类型*/
	private String accountType;
	/**账户级别*/
	private String accountLevel;
	/**页码(必填)*/
	private Integer pageNo;
	/**单页大小(必填)*/
	private Integer pageSize;

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
}
