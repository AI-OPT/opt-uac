package com.ai.opt.uac.api.system.sysaccount.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;


public class AccountPageQueryResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;

	private PageInfo<AccountPageQueryData> pageInfo;

	public PageInfo<AccountPageQueryData> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<AccountPageQueryData> pageInfo) {
		this.pageInfo = pageInfo;
	}
}
